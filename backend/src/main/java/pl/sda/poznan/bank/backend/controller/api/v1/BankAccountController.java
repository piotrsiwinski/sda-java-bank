package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.service.impl.BankAccountServiceImpl;
import pl.sda.poznan.bank.backend.service.impl.OperationHistoryServiceImpl;
import pl.sda.poznan.bank.backend.service.impl.UserServiceImpl;


@Controller
@RequestMapping("/api/v1/bank")
public class BankAccountController {

    BankAccountServiceImpl bankAccountService;
    OperationHistoryServiceImpl history;
    UserServiceImpl userService;

    public BankAccountController(OperationHistoryServiceImpl history, UserServiceImpl userService) {
        this.history = history;
        this.userService = userService;
    }

    @Autowired(required = false)
    public void setBankAccountService(BankAccountServiceImpl bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
}
