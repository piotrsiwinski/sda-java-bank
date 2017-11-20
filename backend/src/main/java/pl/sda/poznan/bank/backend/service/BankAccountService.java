
package pl.sda.poznan.bank.backend.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.sda.poznan.bank.backend.model.AccountType;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.User;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Component
public class BankAccountService {


    private BankAccount bankAccount;

    public Boolean payment(Long amount, User secondUser){
        Long balance = bankAccount.getBalance();
        if(amount!=null && amount > 0){
            if(balance != null && balance > amount){
                Long secondBalance = secondUser.getBankAccount().getBalance();
                secondBalance +=amount;
                balance -= amount;
                return true;
            }

        }
        return false;

    }

}

