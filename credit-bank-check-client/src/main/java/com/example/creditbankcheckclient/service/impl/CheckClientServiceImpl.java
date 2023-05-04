package com.example.creditbankcheckclient.service.impl;

import com.example.creditbankcheckclient.dto.CheckResponseDTO;
import com.example.creditbankcheckclient.dto.RequestFormDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.entity.CheckClientEntity;
import com.example.creditbankcheckclient.mapper.ClientAndBidMapper;
import com.example.creditbankcheckclient.repository.CheckBidRepository;
import com.example.creditbankcheckclient.repository.CheckClientRepository;
import com.example.creditbankcheckclient.service.CheckClientService;
import com.example.creditbankcheckclient.service.IsInBlackListResttemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;


/**
 */
@Service
public class  CheckClientServiceImpl implements CheckClientService {

    private Boolean bankConfirm;

    private double percentYear;

    private static final int MIN_AMOUNT_MONEY = 25000;

    @Autowired
    private CheckBidRepository checkBidRepository;

    @Autowired
    private CheckClientRepository checkClientRepository;

    @Autowired
    private ClientAndBidMapper clientAndBidMapper ;

    @Autowired
    private IsInBlackListResttemplateService isInBlackListResttemplateService;

    /**
     *  Вычисляет ежемесячный платеж
     */

    private double monthlyPayment(double creditAmount, double creditTerm, double percentYear) {

        double kMonth = percentYear / 12 / 100;
        double stavkaobsh = Math.pow((1 + kMonth), creditTerm);
        double monthPayment = Math.floor(creditAmount * kMonth * stavkaobsh / (stavkaobsh - 1));
        return monthPayment;
    }

    /**
     *   Возвращает новый номер заявки - запрашивет из базы данных последний номер заявки и увеличивает на 1
     */

    public String getNewBidNumber() {

        CheckBidEntity topByOrderByIdDesc = checkBidRepository.getTopByOrderByIdDesc();
        String lastBidNumber = topByOrderByIdDesc.getBidNumber();

        String[] arr = lastBidNumber.split("Д23-[0]*");
        String secondSubstr = arr[1];
        int i = Integer.parseInt(secondSubstr) + 1;
        int excl = secondSubstr.length();
        String firstSubstr = lastBidNumber.substring(0, lastBidNumber.length() - excl);
        String newBidNum = firstSubstr + i;

        return newBidNum;
    }

    private String checkByPassportNumMessage() {
        return "Имя, отчество или фамилия не соответствует номеру паспорта. Введите корректные данные ";
    }

    /**
     *   Заполняет экземпляры CheckClientEntity и CheckBidEntity
     *   на основе requestFormDTO, percentYear - годовой процентной ставки и bankConfirm - подтверждения/отказа банка
     *   и сохраняет записи, соответственно, в checkclient_table и checkbid_table
     */

    private void clientAndBidEntitiesSet(RequestFormDTO requestFormDTO, double percentYear, boolean bankConfirm) {

        CheckClientEntity checkClientEntity = clientAndBidMapper.dtoToEntity(requestFormDTO);

        CheckBidEntity checkBidEntity = clientAndBidMapper.dtoToEntity(requestFormDTO, percentYear, bankConfirm);
        checkBidEntity.setBidNumber(getNewBidNumber());

        CheckClientEntity checkClientEntityByPassportNum = checkClientRepository.getCheckClientEntityByPassportNum(requestFormDTO.getPassportNum());

        if (checkClientEntityByPassportNum != null) {
            if ( checkFields(checkClientEntity, checkClientEntityByPassportNum)) {
                checkBidEntity.setCheckClientEntity(checkClientEntityByPassportNum);
                checkBidRepository.save(checkBidEntity);

            } else {
                throw new RuntimeException(checkByPassportNumMessage());
            }

        } else {
            checkClientRepository.save(checkClientEntity);
            CheckClientEntity persistedEntity = checkClientRepository.getCheckClientEntityByPassportNum(requestFormDTO.getPassportNum());
            checkBidEntity.setCheckClientEntity(persistedEntity);
            checkBidRepository.save(checkBidEntity);
        }
    }

    /**
     *   В случае, если в checkclient_table уже содержится клиент с таким же номером паспорта passportNum как в checkClientEntity,
     *   проверяет соответствие имени, отчества и фамилии и номера паспорта в заявке и в checkclient_table
     */

    private boolean checkFields(CheckClientEntity checkClientEntity, CheckClientEntity checkClientEntityByPassportNum) {

        return checkClientEntity.getFirstName().equals(checkClientEntityByPassportNum.getFirstName())
                && checkClientEntity.getSurName().equals(checkClientEntityByPassportNum.getSurName())
                && checkClientEntity.getLastName().equals(checkClientEntityByPassportNum.getLastName());
    }

    /**
     *  В соответствии с данными из requestFormDTO и запроса в black-list-service,
     *  выдает либо отказ, либо согласие на выдачу кредита,
     *  в зависимости от данных из requestFormDTO предлагается годовая процентная ставка.
     *  Как в случае отказа, так и в случае согласия банка, производится запись в checkclient_table и checkbid_table.
     *  В случае, если запрашиваемая клиентом сумма выше, чем одобряет банк, запись в БД не производится,
     *  а клиенту предлагаются возможные для его случая условия.
     *  Во всех случаях возвращает CheckResponseDTO с ответом на заявку.
     */

    public CheckResponseDTO checkFormClient(RequestFormDTO requestFormDTO) {

        boolean isEmployed = requestFormDTO.isEmployed();
        double timeOfEmployment = requestFormDTO.getTimeOfEmployment();
        double salary = requestFormDTO.getSalary();
        double loanPayments = requestFormDTO.getLoanPayments();
        double creditAmount = requestFormDTO.getCreditAmount();
        double creditTerm = requestFormDTO.getCreditTerm();

        CheckResponseDTO checkResponseDTO = new CheckResponseDTO();

        boolean blackListResponse;
        try {
            blackListResponse = isInBlackListResttemplateService.getBlackListResponse(requestFormDTO.getPassportNum());
        } catch (NullPointerException ex ){
            checkResponseDTO.setMessage("Null ответ с BlackListService");
            return checkResponseDTO;
        } catch (ResourceAccessException ex){
            checkResponseDTO.setMessage("Нет доступа к BlackListService" );
            return checkResponseDTO;
        }

        double maxMonthPayment = salary - loanPayments - MIN_AMOUNT_MONEY;

        double maxCreditAmount = maxMonthPayment * creditTerm;


        if (blackListResponse == true && isEmployed == false) {

            checkResponseDTO.setMessage("Вам отказано в кредите - у Вас плохая кредитная история и Вы не трудоустроены");


        } else if (blackListResponse == true && isEmployed == true && timeOfEmployment >= 12 && maxMonthPayment >= 5000) {

            percentYear = 30;
            checkResponseDTO.setMessage("Вам доступен кредит 50000 под " + percentYear + " % годовых, сроком от 1 до 3 лет");

        } else if (blackListResponse == false && isEmployed == false) {

            percentYear = 25;
            checkResponseDTO.setMessage("Вам доступен кредит 50000 под " + percentYear + " % годовых, сроком от 1 до 3 лет");

        } else if (blackListResponse == false && isEmployed == true && timeOfEmployment < 3) {

            percentYear = 20;
            double monthPayment = monthlyPayment(creditAmount, creditTerm, percentYear);

            if (maxMonthPayment < monthPayment) {

                checkResponseDTO.setMessage("На срок " + creditTerm + " мес. " + "Вам доступна сумма не более" +
                        maxCreditAmount + " под " + percentYear + "% годовых");

            } else {
                bankConfirm = true;
                clientAndBidEntitiesSet(requestFormDTO, percentYear, bankConfirm);

                CheckBidEntity topByOrderByIdDesc = checkBidRepository.getTopByOrderByIdDesc();
                String bidNumber = topByOrderByIdDesc.getBidNumber();

                checkResponseDTO.setMessage("Вам одобрен кредит на сумму " + creditAmount + " рублей на срок " +
                        creditTerm + " мес. под " + percentYear + "% годовых, ежемесячный платеж " + monthPayment + " рублей, " +
                        "номер заявки - " + bidNumber);

            }

        } else if (blackListResponse == false && isEmployed == true && timeOfEmployment > 3 && timeOfEmployment < 12) {

            percentYear = 17;
            double monthPayment = monthlyPayment(creditAmount, creditTerm, percentYear);

            if (maxMonthPayment < monthPayment) {

                checkResponseDTO.setMessage("На срок " + creditTerm + " мес. " + "Вам доступна сумма не более" +
                        maxCreditAmount + " под " + percentYear + "% годовых");

            } else {
                bankConfirm = true;
                clientAndBidEntitiesSet(requestFormDTO, percentYear, bankConfirm);
                CheckBidEntity topByOrderByIdDesc = checkBidRepository.getTopByOrderByIdDesc();
                String bidNumber = topByOrderByIdDesc.getBidNumber();

                checkResponseDTO.setMessage("Вам одобрен кредит на сумму " + creditAmount + " рублей на срок " +
                        creditTerm + " мес. под " + percentYear + "% годовых, ежемесячный платеж " + monthPayment + " рублей, " +
                        "номер заявки - " + bidNumber);
            }

        } else if (blackListResponse == false && isEmployed == true && timeOfEmployment > 12) {

            percentYear = 13;
            double monthPayment = monthlyPayment(creditAmount, creditTerm, percentYear);

            if (maxMonthPayment < monthPayment) {

                checkResponseDTO.setMessage("На срок " + creditTerm + " мес. " + "Вам доступна сумма не более" +
                        maxCreditAmount + " под " + percentYear + "% годовых");

            } else {
                bankConfirm = true;
                clientAndBidEntitiesSet(requestFormDTO, percentYear, bankConfirm);

                CheckBidEntity topByOrderByIdDesc = checkBidRepository.getTopByOrderByIdDesc();
                String bidNumber = topByOrderByIdDesc.getBidNumber();

                checkResponseDTO.setMessage("Вам одобрен кредит на сумму " + creditAmount + " рублей на срок " +
                        creditTerm + " мес. под " + percentYear + "% годовых, ежемесячный платеж " + monthPayment + " рублей, " +
                        "номер заявки - " + bidNumber);
            }
        }
        return checkResponseDTO;
    }
}
