package com.example.creditbankapprovedclient.service.impl;

import com.example.creditbankapprovedclient.entity.ContractEntity;
import com.example.creditbankapprovedclient.service.PaymentsCalc;
import com.example.creditbankapprovedclient.service.PaymentsSchedule;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentsCalcImpl implements PaymentsCalc{
    @Override
    public List<PaymentsSchedule> getPaymentsSchedule(ContractEntity contractEntity) {

        double creditAmount = contractEntity.getCreditAmount();  //(kredit)
        double creditTerm = contractEntity.getCreditTerm();     //Срок кредита - (srok )
        double percentYear = contractEntity.getPercentYear();   //Годовая ставка
        double loanBalance = creditAmount;                      //Остаток по кредиту - (ostatok)
        double kMonth = percentYear/12/100;                     //(stavkames)
        int month = 1;
        double stavkaobsh = Math.pow((1 + kMonth), creditTerm);
        double monthPayment = creditAmount * kMonth * stavkaobsh / (stavkaobsh - 1);
        double totalOverpayment = 0;
        totalOverpayment = monthPayment * creditTerm - creditAmount;


        List<PaymentsSchedule> paymentsScheduleList = new ArrayList<>();

        while (loanBalance > 0 ){

            PaymentsSchedule paymentsSchedule = new PaymentsSchedule();

            double percentNow = loanBalance * kMonth;               //Выплата по процентам в текущем платеже
            loanBalance = loanBalance + percentNow - monthPayment;

            if(monthPayment > loanBalance ){
//               monthPayment = loanBalance;

                paymentsSchedule.setMonth(month);
                paymentsSchedule.setMonthPayment(loanBalance);
                paymentsSchedule.setPercentNow(percentNow);
                paymentsSchedule.setLoanBalance(loanBalance);
                paymentsSchedule.setTotalOverpayment(totalOverpayment);

                paymentsScheduleList.add(paymentsSchedule);
 //              break;
            }

            paymentsSchedule.setMonth(month);
            paymentsSchedule.setMonthPayment(monthPayment);
            paymentsSchedule.setPercentNow(percentNow);
            paymentsSchedule.setLoanBalance(loanBalance);

            paymentsScheduleList.add(paymentsSchedule);

            month++;

        }
        return paymentsScheduleList;
    }
}

//    public double grafikPlatezey() {
//        double totalPereplata = 0;
//        double ostatok = kredit;
//        int mesyac = 1;
//        System.out.println("Месяц, Остаток , Процент ");
//        if (dif == false) {                     // а можно так :(!dif) - это false, (dif) - это true
//            double stavkaobsh = Math.pow((1 + stavkames), srok);
//            double platez = kredit * stavkames * stavkaobsh / (stavkaobsh - 1);
//            totalPereplata = platez * srok - kredit;
//            while (ostatok > 0) {
//                double procentNow = ostatok * stavkames;
//                System.out.format(" %d,  %.2f,  %.2f%n", mesyac, ostatok, procentNow);
//                ostatok = ostatok + procentNow - platez;
//                mesyac++;
//
//            }
//        } else {
//            double dolgMes = kredit / srok;
//            while (ostatok > 0) {
//                double procentNow = ostatok * stavkames;
//                double platezDif = dolgMes + procentNow;
//                totalPereplata += procentNow;
//                System.out.format(" %d,  %.2f,  %.2f%n", mesyac, ostatok, procentNow);
//                ostatok = ostatok + procentNow - platezDif;
//                mesyac++;
//            }
//        }
//        return totalPereplata;
//    }
