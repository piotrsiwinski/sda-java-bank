//TODO napisz kredyt, jak masz napisac dzielenie rat na podstawie kwoty ktorya jest kredytem, jak ja pobrac?
package pl.sda.poznan.bank.backend.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.User;

@Service
public class CreditService {

    public CreditService() {

    }


    public boolean getCredit(Double amount) {
        User user = new User();
        if (user.getBankAccount().get(0).getAccountType().equals("PREMIUM")) {
            if (amount != null && amount > 0) {
                Double balance = user.getBankAccount().get(0).getBalance();
                balance += amount;
                System.out.println("Dokonano pozyczki na kwote: " + amount + ". Saldo: " + balance);
                return true;
            }
        }
        return false;
    }

    public void creditRepayment() {
        String installments;
    }
}

