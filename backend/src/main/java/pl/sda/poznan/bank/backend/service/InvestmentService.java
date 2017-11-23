package pl.sda.poznan.bank.backend.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.User;


@Service
public class InvestmentService {

    public Double investmentPayment(Double amount, User user){
//        Double balance = user.getBankAccount().getBalance();
//        if(user.getBankAccount().getAccountType().equals("DEPOSIT")){
//            if(amount != null && amount > 0){
//                balance+=amount;
//                System.out.println("Dokonano wplaty " + amount + ". Saldo: " + balance);
//            }
//        }
//        return balance;
        return null;
    }

//    public Double withdrawDuringInvestmentPeriod(Double amount, User user, Double interest){
//        Double balance = user.getBankAccount().getBalance();
//        amount*=interest;
//        if(user.getBankAccount().getAccountType().equals("DEPOSIT")){
//            if(amount != null && amount <= balance){
//                balance-=amount;
//            }
//        }
//        return balance;
//    }
}
