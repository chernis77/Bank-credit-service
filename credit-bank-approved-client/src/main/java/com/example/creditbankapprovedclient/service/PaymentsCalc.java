package com.example.creditbankapprovedclient.service;

import com.example.creditbankapprovedclient.entity.ContractEntity;

import java.util.List;

public interface PaymentsCalc {

    List<PaymentsSchedule> getPaymentsSchedule(ContractEntity contractEntity);

}
