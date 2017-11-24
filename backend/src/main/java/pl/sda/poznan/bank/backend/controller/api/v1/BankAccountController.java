package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.service.BankAccountService;
import pl.sda.poznan.bank.backend.service.OperationHistoryService;
import pl.sda.poznan.bank.backend.service.UserService;


@Controller
@RequestMapping("/api/v1/bank")
public class BankAccountController {

    BankAccountService bankAccountService;
    OperationHistoryService history;
    UserService userService;

    public BankAccountController(OperationHistoryService history, UserService userService) {
        this.history = history;
        this.userService = userService;
    }

    @Autowired(required = false)
    public void setBankAccountService(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
}
