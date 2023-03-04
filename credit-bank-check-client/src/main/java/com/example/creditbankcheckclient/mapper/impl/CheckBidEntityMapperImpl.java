package com.example.creditbankcheckclient.mapper.impl;

import com.example.creditbankcheckclient.dto.CheckBidDTO;
import com.example.creditbankcheckclient.dto.CheckClientDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.mapper.CheckBidEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CheckBidEntityMapperImpl implements CheckBidEntityMapper {

   public CheckBidDTO checkBidEntityToDTO(CheckBidEntity checkBidEntity){

      CheckBidDTO checkBidDTO = new CheckBidDTO();
      CheckClientDTO checkClientDTO = new CheckClientDTO();

      checkClientDTO.setFirstName(checkBidEntity.getCheckClientEntity().getFirstName());
      checkClientDTO.setSurName(checkBidEntity.getCheckClientEntity().getSurName());
      checkClientDTO.setLastName(checkBidEntity.getCheckClientEntity().getLastName());
      checkClientDTO.setPassportNum(checkBidEntity.getCheckClientEntity().getPassportNum());

      checkBidDTO.setBidNumber(checkBidEntity.getBidNumber());
      checkBidDTO.setEmployed(checkBidEntity.isEmployed());
      checkBidDTO.setTimeOfEmployment(checkBidEntity.getTimeOfEmployment());
      checkBidDTO.setSalary(checkBidEntity.getSalary());
      checkBidDTO.setLoanPayments(checkBidEntity.getLoanPayments());
      checkBidDTO.setCreditAmount(checkBidDTO.getCreditAmount());
      checkBidDTO.setCreditTerm(checkBidEntity.getCreditTerm());
      checkBidDTO.setPercentYear(checkBidEntity.getPercentYear());
      checkBidDTO.setBankConfirm(checkBidEntity.getBankConfirm());
      checkBidDTO.setClientConfirm(checkBidEntity.getClientConfirm());
      checkBidDTO.setCheckClientDTO(checkClientDTO);

      return checkBidDTO;
   }

}
