package com.example.creditbankcheckclient.mapper;

import com.example.creditbankcheckclient.dto.RequestFormDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.entity.CheckClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientAndBidMapper {

  CheckClientEntity dtoToEntity(RequestFormDTO requestFormDTO);

//  @Mapping(target = "percentYear", source = "percentYear")
//  @Mapping(target = "bankConfirm", source = "bankConfirm")
  @Mapping(target = "clientConfirm", ignore = true )
//  @Mapping(target = "bidNumber", source = getNewBidNumber() )
  CheckBidEntity dtoToEntity(RequestFormDTO requestFormDTO, double percentYear, boolean bankConfirm);




}

//         checkBidEntity.setPercentYear(percentYear);
//        checkBidEntity.setBankConfirm(bankConfirm);
//        checkBidEntity.setClientConfirm(null);
//         checkBidEntity.setBidNumber(newBidNumber);