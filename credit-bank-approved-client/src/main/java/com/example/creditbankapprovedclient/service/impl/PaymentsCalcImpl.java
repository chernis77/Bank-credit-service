package com.example.creditbankapprovedclient.service.impl;

import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.service.PaymentsCalc;
import com.example.creditbankapprovedclient.service.PaymentsSchedule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentsCalcImpl implements PaymentsCalc{


    /**
     * Возвращает график платежей в ArrayList
     */
    @Override
    public List<PaymentsSchedule> getPaymentsSchedule(ContractEntity contractEntity) {

        double creditAmount = contractEntity.getCreditAmount();  //Сумма кредита
        double creditTerm = contractEntity.getCreditTerm();     //Срок кредита
        double percentYear = contractEntity.getPercentYear();   //Годовая ставка
        double loanBalance = creditAmount;                      //Остаток по кредиту
        double kMonth = percentYear/12/100;                     //
        int month = 1;
        double stavkaobsh = Math.pow((1 + kMonth), creditTerm);
        double monthPayment = creditAmount * kMonth * stavkaobsh / (stavkaobsh - 1); //Месячный платеж
        double totalOverpayment = monthPayment * creditTerm - creditAmount;          //Переплата по процентам за весь срок кредита

        List<PaymentsSchedule> paymentsScheduleList = new ArrayList<>();

        LocalDate dateOfPayment = LocalDate.now();

        while (month <=creditTerm){

            PaymentsSchedule paymentsSchedule = new PaymentsSchedule();

            dateOfPayment = dateOfPayment.plusMonths(1);

            double percentNow = loanBalance * kMonth;               //Выплата по процентам в текущем платеже
            loanBalance = loanBalance + percentNow - monthPayment;

            paymentsSchedule.setMonth(month);
            paymentsSchedule.setPaymentDate(dateOfPayment.toString());
            paymentsSchedule.setMonthPayment(Math.round(monthPayment));
            paymentsSchedule.setPercentNow(Math.round(percentNow));
            paymentsSchedule.setLoanBalance(Math.round(loanBalance));
            paymentsSchedule.setTotalOverpayment(Math.round(totalOverpayment));

            paymentsScheduleList.add(paymentsSchedule);

            month++;

        }
        return paymentsScheduleList;
    }
}

