package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.service.BankAccountService;
import pl.sda.poznan.bank.backend.service.OperationHistoryService;
import pl.sda.poznan.bank.backend.service.UserService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

import javax.validation.Valid;


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

    @PostMapping(path = "/payment", consumes = "application/json")
    public ResponseEntity Payment(@RequestBody @Valid PaymentAndPayoffVM viewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        bankAccountService.payment(viewModel);

        return ResponseEntity.ok("Dokonano wpłaty");
    }

    @PostMapping(path = "/payoff", consumes = "application/json")
    public ResponseEntity Payoff(@RequestBody @Valid PaymentAndPayoffVM viewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        bankAccountService.payoff(viewModel);

        return ResponseEntity.ok("Dokonano wypłaty");
    }

    @PostMapping(path = "/transfer", consumes = "application/json")
    public ResponseEntity Transaction(@RequestBody @Valid TransferVM viewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        bankAccountService.transfer(viewModel);

        return ResponseEntity.ok("Przelew sie udal");
    }
}
