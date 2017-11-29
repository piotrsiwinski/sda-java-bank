package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.History;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.web.viewmodel.PaymentAndPayoffVM;
import pl.sda.poznan.bank.backend.web.viewmodel.TransferVM;

public interface BankAccountService {
    Boolean payment(PaymentAndPayoffVM viewModel);

    Boolean payoff(PaymentAndPayoffVM viewModel);

    Boolean transfer(TransferVM viewModel);

    BankAccount findById(Long id);

    BankAccount findByUser(User user);
}
