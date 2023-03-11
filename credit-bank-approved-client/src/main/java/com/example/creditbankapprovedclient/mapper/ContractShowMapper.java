package com.example.creditbankapprovedclient.mapper;

import com.example.creditbankapprovedclient.dto.ContractShowDTO;
import com.example.creditbankapprovedclient.entity.ContractEntity;


public interface ContractShowMapper {

    ContractShowDTO getContractShowDTO(ContractEntity contractEntity) ;

}
