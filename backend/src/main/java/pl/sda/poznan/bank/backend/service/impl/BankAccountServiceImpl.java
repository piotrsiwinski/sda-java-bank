package pl.sda.poznan.bank.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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
import pl.sda.poznan.bank.backend.service.BankUserDetailsService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {


    private HistoryRepository historyRepository;

    private BankAccountRepository bankAccountRepository;

    private BankUserDetailsService bankUserDetailsService;

    @Autowired
    public BankAccountServiceImpl(HistoryRepository historyRepository,
                                  BankAccountRepository bankAccountRepository,
                                  BankUserDetailsService bankUserDetailsService) {
        this.historyRepository = historyRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.bankUserDetailsService = bankUserDetailsService;
    }


    @Transactional(rollbackFor = OperationException.class)
    @Override
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
    @Override
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
    @Override
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

    @Override
    public List<BankAccount> getUserAccounts(Principal principal) {
        String username = principal.getName();
        User user = this.bankUserDetailsService.findUserByLogin(username);
        return this.bankAccountRepository.findAllByUser(user);
    }
}






