package com.example.creditbankapprovedclient.test_object;

import com.example.creditbankapprovedclient.dto.TransferBidToApproveDTO;

public class PrepareTestObjectApprovedClient {


    public static TransferBidToApproveDTO prepareValidTestObj(){

        TransferBidToApproveDTO transferBidToApproveDTOtest = new TransferBidToApproveDTO();

        transferBidToApproveDTOtest.setBidNumber("Т20-00000001");
        transferBidToApproveDTOtest.setFirstName("Василий");
        transferBidToApproveDTOtest.setSurName("Васильевич");
        transferBidToApproveDTOtest.setLastName("Васильев");
        transferBidToApproveDTOtest.setPassportNum("1234 567890");
        transferBidToApproveDTOtest.setCreditAmount(200000d);
        transferBidToApproveDTOtest.setCreditTerm(48d);
        transferBidToApproveDTOtest.setPercentYear(13.0);

        return transferBidToApproveDTOtest;
    }
}


//    private String bidNumber;
//
//    private String firstName;
//
//    private String surName;
//
//    private String lastName;
//
//    private String passportNum;
//
//    private Double creditAmount;          //Сумма кредита в рублях
//
//    private Double creditTerm;           //Срок кредита в месяцах - от 12 до 60
//
//    private Double percentYear;
