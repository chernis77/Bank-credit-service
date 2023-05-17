package com.example.creditbankapprovedclient.mapper.impl;

import com.example.creditbankapprovedclient.dto.ContractShowDTO;
import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.mapper.ContractShowMapper;
import com.example.creditbankapprovedclient.mapper.ContractShowMapstruct;
import com.example.creditbankapprovedclient.service.PaymentsCalc;
import com.example.creditbankapprovedclient.service.PaymentsSchedule;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractShowMapperImpl implements ContractShowMapper {

    @Autowired
    private PaymentsCalc paymentsCalc;

    @Autowired
    private ContractShowMapstruct contractShowMapstruct;

    public ContractShowDTO getContractShowDTO(ContractEntity contractEntity) {

//        ContractShowDTO contractShowDTO = new ContractShowDTO();
//        List<PaymentsSchedule> paymentsScheduleList = paymentsCalc.getPaymentsSchedule(contractEntity);

//        contractShowDTO.setContractNumber(contractEntity.getContractNumber());
//        contractShowDTO.setFirstName(contractEntity.getApprovedClientEntity().getFirstName());
//        contractShowDTO.setSurName(contractEntity.getApprovedClientEntity().getSurName());
//        contractShowDTO.setLastName(contractEntity.getApprovedClientEntity().getLastName());
//        contractShowDTO.setPassportNum(contractEntity.getApprovedClientEntity().getPassportNum());
//        contractShowDTO.setCreditAmount(contractEntity.getCreditAmount());
//        contractShowDTO.setCreditTerm(contractEntity.getCreditTerm());
//        contractShowDTO.setPercentYear(contractEntity.getPercentYear());
//        contractShowDTO.setPaymentsScheduleList(paymentsScheduleList);

        return contractShowMapstruct.getContractShowDTO(contractEntity, paymentsCalc.getPaymentsSchedule(contractEntity));
    }
}
