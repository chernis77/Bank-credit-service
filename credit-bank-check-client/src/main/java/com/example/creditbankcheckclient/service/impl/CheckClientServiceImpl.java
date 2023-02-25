package com.example.creditbankcheckclient.service.impl;

import com.example.creditbankcheckclient.dto.CheckResponseDTO;
import com.example.creditbankcheckclient.dto.RequestFormDTO;
import com.example.creditbankcheckclient.resttemplate.IsInBlackListResttemplate;
import com.example.creditbankcheckclient.service.CheckClientService;
import org.springframework.stereotype.Service;


/**
 * Если клиент в черном списке и не работает - отказ в кредите.
 * Если клиент в черном списке, но работает более 12мес - одобряем до 50000 на срок от 3 до 5 лет, 22%
 * Если клиента нет в черном списке и не работает - одобряем до 50000 на срок от 3 до 5 лет, 20%
 * Если клиента нет в черном списке, работает до 3 мес - одобряем (зарплата-кредитная нагрузка-minAmountMoney)*0,25 , 17%
 * Если клиента нет в черном списке, работает от 3 до 12 мес - одобряем ежемес.платеж не более: (зарплата-кредитная нагрузка-minAmountMoney)*0,5 , 15%
 * Если клиента нет в черном списке, работает более 12 мес - одобряем: ежемес.платеж не более: зарплата-кредитная нагрузка-minAmountMoney, 12%
 */
@Service
public class CheckClientServiceImpl implements CheckClientService {

    private boolean isInBlackList;

    private double percentYear;

    private static final int MIN_AMOUNT_MONEY = 25000;

//    RequestFormDTO fillInRequestFormDTO(String firstName,
//                                        String surName,
//                                        String lastName,
//                                        String passportNum,
//                                        boolean isEmployed,
//                                        int timeOfEmployment,
//                                        double salary,
//                                        double loanPayments,
//                                        double creditAmount,
//                                        double creditTerm
//    ) {
//        RequestFormDTO requestFormDTO = new RequestFormDTO();
//
//        requestFormDTO.setFirstName(firstName);
//        requestFormDTO.setSurName(surName);
//        requestFormDTO.setLastName(lastName);
//        requestFormDTO.setPassportNum(passportNum);
//        requestFormDTO.setEmployed(isEmployed);
//        requestFormDTO.setTimeOfEmployment(timeOfEmployment);
//        requestFormDTO.setSalary(salary);
//        requestFormDTO.setLoanPayments(loanPayments);
//        requestFormDTO.setCreditAmount(creditAmount);
//        requestFormDTO.setCreditTerm(creditTerm);
//
//        return requestFormDTO;
//    }

    boolean isInBlackListCheck(String passportNum) {

        IsInBlackListResttemplate isInBlackListResttemplate = new IsInBlackListResttemplate();
        boolean inBlackListRequest = isInBlackListResttemplate.isInBlackListRequest(passportNum);
        return inBlackListRequest;
    }

    double monthlyPayment(double creditAmount, double creditTerm, double percentYear) {

        double kMonth = percentYear / 12 / 100;
        double stavkaobsh = Math.pow((1 + kMonth), creditTerm);
        double monthPayment = Math.floor(creditAmount * kMonth * stavkaobsh / (stavkaobsh - 1));
        return monthPayment;
    }


    public CheckResponseDTO checkFormClient(RequestFormDTO requestFormDTO) {

        boolean isEmployed = requestFormDTO.isEmployed();
        double timeOfEmployment = requestFormDTO.getTimeOfEmployment();
        double salary = requestFormDTO.getSalary();
        double loanPayments = requestFormDTO.getLoanPayments();
        double creditAmount = requestFormDTO.getCreditAmount();
        double creditTerm = requestFormDTO.getCreditTerm();


        boolean isInBlackList = isInBlackListCheck(requestFormDTO.getPassportNum());

        double monthPayment = monthlyPayment(creditAmount, creditTerm, percentYear);

        double maxMonthPayment = salary - loanPayments - MIN_AMOUNT_MONEY;

        double maxCreditAmount = maxMonthPayment * creditTerm;


        CheckResponseDTO checkResponseDTO = new CheckResponseDTO();


        if (isInBlackList == true && isEmployed == false) {

            checkResponseDTO.setMessage("Вам отказано в кредите - у Вас плохая кредитная история и Вы не трудоустроены");


        } else if (isInBlackList == true && isEmployed == true && timeOfEmployment >= 12 && maxMonthPayment >= 5000) {

            percentYear = 30;
            checkResponseDTO.setMessage("Вам доступен кредит 50000 под " + percentYear + " % годовых, сроком от 1 до 3 лет");

        } else if (isInBlackList == false && isEmployed == false) {

            percentYear = 25;
            checkResponseDTO.setMessage("Вам доступен кредит 50000 под " + percentYear + " % годовых, сроком от 1 до 3 лет");

        } else if (isInBlackList == false && isEmployed == true && timeOfEmployment < 3) {

            percentYear = 20;

            if (maxMonthPayment < monthPayment) {

                checkResponseDTO.setMessage("На срок " + creditTerm + " мес. " + "Вам доступна сумма не более" +
                        maxCreditAmount + " под " + percentYear + "% годовых");

            } else {
                checkResponseDTO.setMessage("Вам одобрен кредит на сумму " + creditAmount + " рублей на срок " +
                        creditTerm + " мес. под " + percentYear + "% годовых, ежемесячный платеж " + monthPayment + " рублей");
            }

        } else if (isInBlackList == false && isEmployed == true && timeOfEmployment > 3 && timeOfEmployment < 12) {

            percentYear = 17;

            if (maxMonthPayment < monthPayment) {

                checkResponseDTO.setMessage("На срок " + creditTerm + " мес. " + "Вам доступна сумма не более" +
                        maxCreditAmount + " под " + percentYear + "% годовых");

            } else {
                checkResponseDTO.setMessage("Вам одобрен кредит на сумму " + creditAmount + " рублей на срок " +
                        creditTerm + " мес. под " + percentYear + "% годовых, ежемесячный платеж " + monthPayment + " рублей");
            }
        } else if (isInBlackList == false && isEmployed == true && timeOfEmployment > 12) {

            percentYear = 13;

            if (maxMonthPayment < monthPayment) {

                checkResponseDTO.setMessage("На срок " + creditTerm + " мес. " + "Вам доступна сумма не более" +
                        maxCreditAmount + " под " + percentYear + "% годовых");

            } else {
                checkResponseDTO.setMessage("Вам одобрен кредит на сумму " + creditAmount + " рублей на срок " +
                        creditTerm + " мес. под " + percentYear + "% годовых, ежемесячный платеж " + monthPayment + " рублей");
            }
        }

        return checkResponseDTO;
    }

}