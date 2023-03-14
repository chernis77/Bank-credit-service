package com.example.creditbankapprovedclient.service.impl;

import com.example.creditbankapprovedclient.dto.TransferBidToApproveDTO;
import com.example.creditbankapprovedclient.entity.ApprovedClientEntity;
import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.repository.ApprovedClientRepository;
import com.example.creditbankapprovedclient.repository.ContractRepository;
import com.example.creditbankapprovedclient.service.SetFromBidToEntitiesAndSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetFromBidToEntitiesAndSaveServiceImpl implements SetFromBidToEntitiesAndSaveService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ApprovedClientRepository approvedClientRepository;

    public void setAndSaveFromBidToContract(TransferBidToApproveDTO transferBidToApproveDTO) {

        ApprovedClientEntity approvedClientEntity = new ApprovedClientEntity();
        ContractEntity contractEntity = new ContractEntity();

        approvedClientEntity.setFirstName(transferBidToApproveDTO.getFirstName());
        approvedClientEntity.setSurName(transferBidToApproveDTO.getSurName());
        approvedClientEntity.setLastName(transferBidToApproveDTO.getLastName());
        approvedClientEntity.setPassportNum(transferBidToApproveDTO.getPassportNum());
        ApprovedClientEntity uncludeEntity = approvedClientRepository.getApprovedClientEntitiesByPassportNum(transferBidToApproveDTO.getPassportNum());
        if(uncludeEntity == null){
            approvedClientEntity.setContractEntityList(null);
        }else{
            approvedClientEntity.setContractEntityList(uncludeEntity.getContractEntityList());
        }

        contractEntity.setContractNumber(transferBidToApproveDTO.getBidNumber());
        contractEntity.setCreditAmount(transferBidToApproveDTO.getCreditAmount());
        contractEntity.setCreditTerm(transferBidToApproveDTO.getCreditTerm());
        contractEntity.setPercentYear(transferBidToApproveDTO.getPercentYear());

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

    public String contractResponseMessage(String bidNumber) {

        ContractEntity contractEntityByContractNumber = contractRepository.getContractEntityByContractNumber(bidNumber);

        String contractNumber = contractEntityByContractNumber.getContractNumber();
        Double creditAmount = contractEntityByContractNumber.getCreditAmount();
        Double creditTerm = contractEntityByContractNumber.getCreditTerm();
        Double percentYear = contractEntityByContractNumber.getPercentYear();
        String firstName = contractEntityByContractNumber.getApprovedClientEntity().getFirstName();
        String surName = contractEntityByContractNumber.getApprovedClientEntity().getSurName();
        String lastName = contractEntityByContractNumber.getApprovedClientEntity().getLastName();

        return "Заключён кредитный договор №" + contractNumber + " , " + creditAmount + " руб. на срок "
                + creditTerm + " мес. под " + percentYear + "% годовых " + firstName + " " + surName + " " + lastName;

    }

}
