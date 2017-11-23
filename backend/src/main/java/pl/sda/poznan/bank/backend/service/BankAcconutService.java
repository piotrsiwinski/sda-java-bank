package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;

@Service
public class BankAcconutService {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAcconutService(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    public void addAccount(BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
    }

    public void deleteAccount(long id){

    }

}
