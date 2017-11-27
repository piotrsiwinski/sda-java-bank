package pl.sda.poznan.bank.backend.service;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import pl.sda.poznan.bank.backend.exception.OperationException;
import pl.sda.poznan.bank.backend.model.*;

import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;


import java.time.LocalDate;

@Service
public class BankAccountService {


    private HistoryRepository historyRepository;

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(HistoryRepository historyRepository, BankAccountRepository bankAccountRepository) {
        this.historyRepository = historyRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Transactional(rollbackFor = OperationException.class)
    public Boolean payment(PaymentAndPayoffVM viewModel) {
        BankAccount myBankAccount = bankAccountRepository.findByAccountNumber(viewModel.getSourceAccountNumber());
        double amount = viewModel.getAmount();
        double balance = myBankAccount.getBalance();

        if (amount < 0) {
            throw new OperationException("Kwota wpłaty nie możę być mniejsza od 0");
        }

        balance += amount;

        History history = new History(OperationType.PAYMENT, LocalDate.now(),
                "Dokonano operacji wpłaty dnia: " + LocalDate.now() + " na kwotę " + amount);
        historyRepository.save(history);
        return true;

    }


    @Transactional(rollbackFor = OperationException.class)
    public Boolean payoff(PaymentAndPayoffVM viewModel) {
        BankAccount myBankAccount = bankAccountRepository.findByAccountNumber(viewModel.getSourceAccountNumber());
        double amount = viewModel.getAmount();
        double balance = myBankAccount.getBalance();

        if (amount < 0) {
            throw new OperationException("Kwota wypłaty nie możę być mniejsza od 0");
        }
        if (myBankAccount.getBalance() < amount) {
            throw new OperationException("Za mało srodków na koncie");
        }

        balance -= amount;

        History history = new History(OperationType.PAYOFF, LocalDate.now(),
                "Dokonano operacji wypłaty dnia: " + LocalDate.now() + " na kwotę " + amount);
        historyRepository.save(history);
        return true;

    }

    @Transactional(rollbackFor = OperationException.class)
    public Boolean transfer(TransferVM viewModel) throws OperationException {
        BankAccount myAccount = bankAccountRepository.findByAccountNumber(viewModel.getSourceAccountNumber());
        BankAccount destinationAccount = bankAccountRepository.findByAccountNumber(viewModel.getDestinationAccountNumber());
        double myBalance = myAccount.getBalance();
        double amount = viewModel.getAmount();
        double destinationBalance = destinationAccount.getBalance();

        if (amount < 0) {
            throw new OperationException("Kwota jest mniejsza od zera");
        }

        if (myAccount.getBalance() < amount) {
            throw new OperationException("Za mało srodków na koncie");
        }

        myBalance -= amount;
        destinationBalance = +amount;
        History history = new History(OperationType.TRANSFER, LocalDate.now(),
                "Dokonano operacji przelewu dnia: " + LocalDate.now() + " na kwotę " + amount);
        historyRepository.save(history);
        return true;

    }
}






