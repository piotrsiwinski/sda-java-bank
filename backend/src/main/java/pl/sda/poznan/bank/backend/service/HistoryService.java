package pl.sda.poznan.bank.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.HistoryRepository;

import javax.persistence.OneToOne;

@Service
public class HistoryService {

    private BankAccountService bankAccountService;

    private OperationHistory operationHistory;

    private UserService userService;

    private HistoryRepository historyRepository;

    @OneToOne
    private User user;



    @Autowired
    public HistoryService(BankAccountService bankAccountService, OperationHistory operationHistory, UserService userService) {
        this.bankAccountService = bankAccountService;
        this.operationHistory = operationHistory;
        this.userService = userService;
    }

}
