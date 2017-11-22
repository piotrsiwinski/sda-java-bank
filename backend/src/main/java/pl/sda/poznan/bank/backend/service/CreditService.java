//TODO napisz kredyt, jak masz napisac dzielenie rat na podstawie kwoty ktorya jest kredytem, jak ja pobrac?
package pl.sda.poznan.bank.backend.service;


import org.springframework.stereotype.Component;
import pl.sda.poznan.bank.backend.model.User;


public class CreditService {

    private User user;


    public CreditService(User user) {
        this.user = user;
    }


    public boolean getCredit(Double amount) {
        if (user.getBankAccount().getAccountType().equals("PREMIUM")) {
            if (amount != null && amount > 0) {
                Double balance = user.getBankAccount().getBalance();
                balance += amount;
                System.out.println("Dokonano pozyczki na kwote: " + amount + ". Saldo: " + balance);
                return true;
            }
        }
        return false;
    }

    public void creditRepayment(){
       String installments;
    }
}

