package pl.sda.poznan.bank.backend.service;

import bank.labs.model.Client;
import bank.labs.repository.HistoryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.OneToOne;

@Getter
public class HistoryService {

    private BankAccountService bankAccountService;

    private OperationHistory operationHistory;

    private ClientService clientService;

    private HistoryRepository historyRepository;

    @OneToOne
    private Client client;



    @Autowired
    public HistoryService(BankAccountService bankAccountService, OperationHistory operationHistory, ClientService clientService) {
        this.bankAccountService = bankAccountService;
        this.operationHistory = operationHistory;
        this.clientService = clientService;
    }

}
