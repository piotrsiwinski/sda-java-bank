package pl.sda.poznan.bank.backend.service.impl;


import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.*;
import pl.sda.poznan.bank.backend.service.InterestService;

import java.time.Period;
@Service
public class InterestServiceImpl implements InterestService {




    @Override
    public Double creditInterestCounter(Credit credit) {

        Double interestValue;
        Double bankAccountBalance = credit.getCreditBalance();
        Double interestInPercent = credit.getInterest().getInterestInPercent();
        if (Period.between(credit.getStartCreditDate(), credit.getEndCreditDate()) != null || Period.between(credit.getStartCreditDate(), credit.getEndCreditDate()).isZero()) {
            int period = Period.between(credit.getStartCreditDate(), credit.getEndCreditDate()).getDays();
            interestValue = (bankAccountBalance * interestInPercent * period) / 365;
            return interestValue;
        }
        return -1.0;
    }

    @Override
    public Double investmentInterestCounter(Investment investment) {
        Double investmentInterestValue;
        Double investmentBalance = investment.getInvestmentBalance();
        Double interestInPercent = investment.getInterest().getInterestInPercent();
        if (Period.between(investment.getStartInvestmentDate(), investment.getEndInvestmentDate()) != null || Period.between(investment.getStartInvestmentDate(), investment.getEndInvestmentDate()).isZero()) {
            int period = Period.between(investment.getStartInvestmentDate(), investment.getEndInvestmentDate()).getDays();
            investmentInterestValue = ((investmentBalance * interestInPercent) / 100 * period) / 365;
            if(investment.getInterest().getAccountType().equals(AccountType.PREMIUM)){
                investmentInterestValue*=0.2;
            }
            return investmentInterestValue;

        }
        return -1.0;
    }

}





