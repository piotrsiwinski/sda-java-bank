package pl.sda.poznan.bank.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.CreditRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;

public class CreditServiceInjectionImpl implements CreditServiceInjection {
    private BankAccountRepository bankAccountRepository;
    private UserRepository userRepository;
    private CreditRepository creditRepository;
    private InterestServiceImpl interestService;

    @Autowired
    public CreditServiceInjectionImpl(BankAccountRepository bankAccountRepository, UserRepository userRepository, CreditRepository creditRepository, InterestServiceImpl interestService) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
        this.creditRepository = creditRepository;
        this.interestService = interestService;
    }



    @Override
    public CreditServiceImpl getCreditInterest() {
        return new CreditServiceImpl(bankAccountRepository,userRepository,creditRepository,interestService);
    }
}
