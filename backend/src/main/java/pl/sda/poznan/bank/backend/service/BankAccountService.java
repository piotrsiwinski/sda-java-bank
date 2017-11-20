package bank.labs.service;

import bank.labs.model.BankAccount;
import bank.labs.model.Client;
import bank.labs.model.History;
import bank.labs.model.OperationType;
import bank.labs.repository.HistoryRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BankAccountService {

    private ClientService clientService;

    private HistoryRepository historyRepository;

    private BankAccount bankAccount;


    @Autowired
    public BankAccountService(ClientService clientService, HistoryRepository historyRepository, BankAccount bankAccount) {
        this.clientService = clientService;
        this.bankAccount = bankAccount;
        this.historyRepository = historyRepository;
    }


    public Boolean payment(Double amount, Client client) {
        Double balance = bankAccount.getBalance();

        if (amount != null && amount > 0) {
            balance += amount;
            System.out.println(balance);
            History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                    "Dokonano operacji wpłaty dnia: " + LocalDate.now() + " na kwotę " + amount);

            historyRepository.save(history);
            return true;
        }
        return false;
    }


    public Boolean payoff(Double amount) {
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

    //TODO session.getTransaction().isActive nie dziala, czemu???
    public Boolean transfer(Double amount, Client secondClient) {
        Session session = null;
        Double balance = bankAccount.getBalance();
        if (amount != null && amount > 0) {
            if (balance != null && balance > amount) {
                try {
                    session.getTransaction().begin();
                    Double secondClientBalance = secondClient.getBankAccount().getBalance();
                    secondClientBalance += amount;
                    balance -= amount;
                    History history = new History(OperationType.CONTRIBUTION, LocalDate.now(),
                            "Dokonano operacji przelewu dnia: " + LocalDate.now() + " na kwotę " + amount);
                    historyRepository.save(history);
                    session.getTransaction().commit();
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    if (session != null)
                        session.getTransaction().rollback();
                }

            }
        }

        return false;

    }


}

