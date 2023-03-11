package com.example.creditbankapprovedclient.mapper;

import com.example.creditbankapprovedclient.dto.ContractShowDTO;
import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.service.PaymentsSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractShowMapstruct {

    @Mapping(target = "firstName", source = "contractEntity.approvedClientEntity.firstName")
    @Mapping(target = "surName", source = "contractEntity.approvedClientEntity.surName")
    @Mapping(target = "lastName", source = "contractEntity.approvedClientEntity.lastName")
    @Mapping(target = "passportNum", source = "contractEntity.approvedClientEntity.passportNum")
 //   @Mapping(target = "paymentsScheduleList", source = "paymentsScheduleList")
    ContractShowDTO getContractShowDTO(ContractEntity contractEntity, List<PaymentsSchedule> paymentsScheduleList);

}

