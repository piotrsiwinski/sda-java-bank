package pl.sda.poznan.bank.backend.controller.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.poznan.bank.backend.service.impl.BankAccountServiceImpl;
import pl.sda.poznan.bank.backend.service.OperationHistoryService;
import pl.sda.poznan.bank.backend.service.UserService;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

import javax.validation.Valid;


@Controller
@RequestMapping("/api/v1/bank")
public class BankAccountController {

    private BankAccountServiceImpl bankAccountService;
    private OperationHistoryService history;
    private UserService userService;

    public BankAccountController(OperationHistoryService historyService,
                                 BankAccountServiceImpl bankAccountService,
                                 UserService userService) {
        this.bankAccountService = bankAccountService;
        this.history = history;
        this.userService = userService;
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
