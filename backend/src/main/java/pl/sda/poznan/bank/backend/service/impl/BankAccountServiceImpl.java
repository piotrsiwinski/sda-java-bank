package pl.sda.poznan.bank.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.poznan.bank.backend.exception.OperationException;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.OperationType;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import pl.sda.poznan.bank.backend.service.BankAccountService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

import java.time.LocalDate;

@Service
public class BankAccountServiceImpl implements BankAccountService {


    private HistoryRepository historyRepository;

    private BankAccountRepository bankAccountRepository;

    private BankAccountService bankAccountService;

    @Autowired
    public BankAccountServiceImpl(HistoryRepository historyRepository,
                                  BankAccountRepository bankAccountRepository,
                                  @Lazy BankAccountService bankAccountService) {
        this.historyRepository = historyRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountService = bankAccountService;
    }


    @Transactional(rollbackFor = OperationException.class)
    @Override
    public Boolean payment(PaymentAndPayoffVM viewModel) {
        String sourceAccountNumber = viewModel.getSourceAccountNumber();
        Long sourceAccountNumberParsed = Long.valueOf(sourceAccountNumber);
        BankAccount myBankAccount = bankAccountRepository.findByAccountNumber(sourceAccountNumberParsed);
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
    @Override
    public Boolean payoff(PaymentAndPayoffVM viewModel) {
        String sourceAccountNumber = viewModel.getSourceAccountNumber();
        Long sourceAccountNumberParsed = Long.valueOf(sourceAccountNumber);
        BankAccount myBankAccount = bankAccountRepository.findByAccountNumber(sourceAccountNumberParsed);
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
    @Override
    public Boolean transfer(TransferVM viewModel) throws OperationException {
        String sourceAccountNumber = viewModel.getSourceAccountNumber();
        Long sourceAccountNumberParsed = Long.valueOf(sourceAccountNumber);
        BankAccount myBankAccount = bankAccountRepository.findByAccountNumber(sourceAccountNumberParsed);
        String destinationAccountNumber = viewModel.getDestinationAccountNumber();
        Long destinationAccountNumberParsed = Long.valueOf(destinationAccountNumber);
        BankAccount destinationAccount = bankAccountRepository.findByAccountNumber(destinationAccountNumberParsed);
        double myBalance = myBankAccount.getBalance();
        double amount = viewModel.getAmount();
        double destinationBalance = destinationAccount.getBalance();

        if (amount < 0) {
            throw new OperationException("Kwota jest mniejsza od zera");
        }

        if (myBankAccount.getBalance() < amount) {
            throw new OperationException("Za mało srodków na koncie");
        }

        myBalance -= amount;
        destinationBalance = +amount;
        History history = new History(OperationType.TRANSFER, LocalDate.now(),
                "Dokonano operacji przelewu dnia: " + LocalDate.now() + " na kwotę " + amount);
        historyRepository.save(history);
        return true;

    }

    @Override
    public BankAccount findById(Long id) {
       return bankAccountService.findById(id);
    }

    @Override
    public BankAccount findByUser(User user) {
       return bankAccountService.findByUser(user);
    }
}






