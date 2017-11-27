package pl.sda.poznan.bank.backend.service;


import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.AccountType;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.Interest;
import pl.sda.poznan.bank.backend.model.Investment;

import java.time.Period;
@Service
public class InterestService {



    public Double normalInterestCounter(Interest interest, BankAccount bankAccount) {

        Double interestValue;
        Double bankAccountBalance = bankAccount.getBalance();
        Double interestInPercent = interest.getInterestInPercent();
        if (Period.between(interest.getStartDate(), interest.getEndDate()) != null || Period.between(interest.getStartDate(), interest.getEndDate()).isZero()) {
            int period = Period.between(interest.getStartDate(), interest.getEndDate()).getDays();
            interestValue = (bankAccountBalance * interestInPercent * period) / 365;
            return interestValue;
        }
        return -1.0;
    }

    public Double investmentInterestCounter(Investment investment, Interest interest) {
        Double investmentInterestValue;
        Double investmentBalance = investment.getInvestmentBalance();
        Double interestInPercent = interest.getInterestInPercent();
        if (Period.between(interest.getStartDate(), interest.getEndDate()) != null || Period.between(interest.getStartDate(), interest.getEndDate()).isZero()) {
            int period = Period.between(interest.getStartDate(), interest.getEndDate()).getDays();
            investmentInterestValue = ((investmentBalance * interestInPercent) / 100 * period) / 365;
            if(interest.getAccountType().equals(AccountType.PREMIUM)){
                investmentInterestValue*=0.2;
            }
            return investmentInterestValue;

        }
        return -1.0;
    }
}





