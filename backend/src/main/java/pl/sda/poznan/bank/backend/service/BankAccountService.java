package pl.sda.poznan.bank.backend.service;

import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.*;

import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;


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
    /*public Boolean transfer() {
        BankAccount bankAccount = new BankAccount();
        Session session = null;
        Double balance = bankAccount.getBalance();
        if (amount != null && amount > 0) {
            if (balance != null && balance > amount) {
                try {
                    session.getTransaction().begin();
                    Double secondClientBalance = 0D;//secondUser.getBankAccount().getBalance();
                    secondClientBalance += amount;
                    balance -= amount;
                    History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                            "Dokonano operacji przelewu dnia: " + LocalDate.now() + " na kwotę " + amount);
                    historyRepository.save(history);
                    session.getTransaction().commit();
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    if (session != null *//*&& session.getTransaction().isActive()*//*) {
                        session.getTransaction().rollback();
                    }
                    return false;
                } finally {
                    if (session != null && session.isOpen()) {
                        session.close();
                    }
                }
            }
        }
        return false;*/
    }




}

