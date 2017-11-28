package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.Interest;
import pl.sda.poznan.bank.backend.model.Investment;

public interface InterestService {
    Double credtInterestCounter(Interest interest, BankAccount bankAccount);

    Double investmentInterestCounter(Investment investment, Interest interest);
}
