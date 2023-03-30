package com.example.creditbankapprovedclient.service.impl;

import com.example.creditbankapprovedclient.dto.TransferBidToApproveDTO;
import com.example.creditbankapprovedclient.entity.ApprovedClientEntity;
import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.repository.ApprovedClientRepository;
import com.example.creditbankapprovedclient.repository.ContractRepository;
import com.example.creditbankapprovedclient.service.SetFromBidToEntitiesAndSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetFromBidToEntitiesAndSaveServiceImpl implements SetFromBidToEntitiesAndSaveService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ApprovedClientRepository approvedClientRepository;

    /**
     *    Заполняет экземпляры ApprovedClientEntity и ContractEntity значениями из TransferBidToApproveDTO,
     *    затем сохраняет их в базу данных.
     *
     */
    public void setAndSaveFromBidToContract(TransferBidToApproveDTO transferBidToApproveDTO) {

        ApprovedClientEntity approvedClientEntity = new ApprovedClientEntity();
        ContractEntity contractEntity = new ContractEntity();

        approvedClientEntity.setFirstName(transferBidToApproveDTO.getFirstName());
        approvedClientEntity.setSurName(transferBidToApproveDTO.getSurName());
        approvedClientEntity.setLastName(transferBidToApproveDTO.getLastName());
        approvedClientEntity.setPassportNum(transferBidToApproveDTO.getPassportNum());
        ApprovedClientEntity includeEntity = approvedClientRepository.getApprovedClientEntitiesByPassportNum(transferBidToApproveDTO.getPassportNum());
        if(includeEntity == null){
            approvedClientEntity.setContractEntityList(null);
        }else{
            approvedClientEntity.setContractEntityList(includeEntity.getContractEntityList());
        }

        contractEntity.setContractNumber(transferBidToApproveDTO.getBidNumber());
        contractEntity.setCreditAmount(transferBidToApproveDTO.getCreditAmount());
        contractEntity.setCreditTerm(transferBidToApproveDTO.getCreditTerm());
        contractEntity.setPercentYear(transferBidToApproveDTO.getPercentYear());
        contractEntity.setDateContract();

        ApprovedClientEntity approvedClientEntitiesByPassportNum = approvedClientRepository.getApprovedClientEntitiesByPassportNum(transferBidToApproveDTO.getPassportNum());

        if (approvedClientEntitiesByPassportNum != null) {
            contractEntity.setApprovedClientEntity(approvedClientEntitiesByPassportNum);
            contractRepository.save(contractEntity);
        } else {
            approvedClientRepository.save(approvedClientEntity);
            ApprovedClientEntity persistedEntity = approvedClientRepository.getApprovedClientEntitiesByPassportNum(transferBidToApproveDTO.getPassportNum());
            contractEntity.setApprovedClientEntity(persistedEntity);
            contractRepository.save(contractEntity);
        }
    }


    /**
     *  Возвращает сообщение о заключенном кредитном договоре
     *
     */
    public String contractResponseMessage(String bidNumber) {

        ContractEntity contractEntityByContractNumber = contractRepository.getContractEntityByContractNumber(bidNumber);

        String contractNumber = contractEntityByContractNumber.getContractNumber();
        String contractDate = contractEntityByContractNumber.getDateContract();
        Double creditAmount = contractEntityByContractNumber.getCreditAmount();
        Double creditTerm = contractEntityByContractNumber.getCreditTerm();
        Double percentYear = contractEntityByContractNumber.getPercentYear();
        String firstName = contractEntityByContractNumber.getApprovedClientEntity().getFirstName();
        String surName = contractEntityByContractNumber.getApprovedClientEntity().getSurName();
        String lastName = contractEntityByContractNumber.getApprovedClientEntity().getLastName();

        return "Заключён кредитный договор №" + contractNumber + " , дата  " + contractDate + " , сумма " + creditAmount + " руб. на срок "
                 + creditTerm + " мес. под " + percentYear + "% годовых " + firstName + " " + surName + " " + lastName;

    }

}
