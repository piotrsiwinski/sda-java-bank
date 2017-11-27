package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.service.BankAccountServiceImp;
import pl.sda.poznan.bank.backend.service.OperationHistoryServiceImp;
import pl.sda.poznan.bank.backend.service.UserServiceImp;


@Controller
@RequestMapping("/api/v1/bank")
public class BankAccountController {

    BankAccountServiceImp bankAccountService;
    OperationHistoryServiceImp history;
    UserServiceImp userService;

    public BankAccountController(OperationHistoryServiceImp history, UserServiceImp userService) {
        this.history = history;
        this.userService = userService;
    }

    @Autowired(required = false)
    public void setBankAccountService(BankAccountServiceImp bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
}
