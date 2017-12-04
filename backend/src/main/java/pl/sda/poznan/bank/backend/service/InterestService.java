package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.Credit;
import pl.sda.poznan.bank.backend.model.Interest;
import pl.sda.poznan.bank.backend.model.Investment;

public interface InterestService {
    Double creditInterestCounter(Credit credit);

    Double investmentInterestCounter(Investment investment);
}
