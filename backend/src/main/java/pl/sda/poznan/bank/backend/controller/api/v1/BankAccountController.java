package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.service.BankAccountService;
import pl.sda.poznan.bank.backend.service.impl.BankAccountServiceImpl;
import pl.sda.poznan.bank.backend.service.OperationHistoryService;
import pl.sda.poznan.bank.backend.service.UserService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/api/v1/bank")
public class BankAccountController {

    private BankAccountService bankAccountService;
    private OperationHistoryService history;
    private UserService userService;
    private BankAccountRepository bankAccountRepository;

    public BankAccountController(OperationHistoryService historyService,
                                 @Lazy BankAccountService bankAccountService,
                                 @Lazy UserService userService,
                                 @Lazy BankAccountRepository bankAccountRepository) {
        this.bankAccountService = bankAccountService;
        this.history = history;
        this.userService = userService;
        this.bankAccountRepository = bankAccountRepository;

    }


    @GetMapping("/{user}")
    public ResponseEntity<Object> getBankAccountBalanceByUser(@PathVariable("user") User user) {
        BankAccount byUser = bankAccountService.findByUser(user);
        return ResponseEntity.status(201).body(byUser);
    }

    @PostMapping(path = "/payment", consumes = "application/json")
    public ResponseEntity payment(@RequestBody @Valid PaymentAndPayoffVM viewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        bankAccountService.payment(viewModel);

        return ResponseEntity.ok("Dokonano wpłaty");
    }

    @PostMapping(path = "/payoff", consumes = "application/json")
    public ResponseEntity payoff(@RequestBody @Valid PaymentAndPayoffVM viewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        bankAccountService.payoff(viewModel);

        return ResponseEntity.ok("Dokonano wypłaty");
    }

    @PostMapping(path = "/transfer", consumes = "application/json")
    public ResponseEntity transaction(@RequestBody @Valid TransferVM viewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        bankAccountService.transfer(viewModel);

        return ResponseEntity.ok("Przelew sie udal");
    }
}
