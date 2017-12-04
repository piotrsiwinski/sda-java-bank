package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

import java.security.Principal;
import java.util.List;

public interface BankAccountService {
    Boolean payment(PaymentAndPayoffVM viewModel);

    Boolean payoff(PaymentAndPayoffVM viewModel);

    Boolean transfer(TransferVM viewModel);

    List<BankAccount> getUserAccounts(Principal principal);
}
