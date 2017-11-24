package pl.sda.poznan.bank.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.poznan.bank.backend.controller.api.v1.BankAccountController;
import pl.sda.poznan.bank.backend.model.*;

import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;


import java.time.LocalDate;

@Service
public class BankAccountService {

    private UserService userService;

    private HistoryRepository historyRepository;

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(UserService userService, HistoryRepository historyRepository, BankAccountRepository bankAccountRepository) {
        this.userService = userService;
        this.historyRepository = historyRepository;
        this.bankAccountRepository = bankAccountRepository;
    }


    public Boolean payment(Double amount, User user) {
        BankAccount bankAccount = new BankAccount();
        if (bankAccount.getAccountType().equals(AccountType.STANDARD) || bankAccount.getAccountType().equals(AccountType.PREMIUM)) {

            Double balance = bankAccount.getBalance();

            if (amount != null && amount > 0) {
                balance += amount;
                System.out.println(balance);
                History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                        "Dokonano operacji wpłaty dnia: " + LocalDate.now() + " na kwotę " + amount);

                historyRepository.save(history);
                return true;
            }
        }

        return false;
    }


    public Boolean payoff(Double amount) {
        BankAccount bankAccount = new BankAccount();
        Double balance = bankAccount.getBalance();
        if (amount != null && amount > 0) {
            balance -= amount;
            History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                    "Dokonano operacji wypłaty dnia: " + LocalDate.now() + " na kwotę " + amount);
            historyRepository.save(history);
            return true;
        }
        return false;

    }

    //TODO Controller najpierw, logika tutaj pozniej
    @Transactional
    public Boolean transfer(TransferVM viewModel) {

        BankAccount myAccount = bankAccountRepository.findByAccountNumber(viewModel.getSourceAccountNumber());
        BankAccount destinationAccount = bankAccountRepository.findByAccountNumber(viewModel.getDestinationAccountNumber());
        double myBalance = myAccount.getBalance();
        double amount = viewModel.getAmount();
        double destinationBalance = destinationAccount.getBalance();


        if (amount > 0)
            if (myAccount.getBalance() > amount) {

                myBalance -= amount;

                destinationBalance = +amount;

                History history = new History(OperationType.TRANSFER, LocalDate.now(),
                        "Dokonano operacji przelewu dnia: " + LocalDate.now() + " na kwotę " + amount);
                historyRepository.save(history);
                return true;

            }
        return false;
}


}

