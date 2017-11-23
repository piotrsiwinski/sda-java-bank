package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;

@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    public void addAccount(BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
    }

    public void deleteAccount(long id, BankAccount bankAccount){
        if (bankAccount.getId() == id){
            bankAccountRepository.delete(id);
        }
    }
}
