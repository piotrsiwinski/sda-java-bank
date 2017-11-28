package pl.sda.poznan.bank.backend.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.poznan.bank.backend.exception.OperationException;
import pl.sda.poznan.bank.backend.model.AccountType;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.Credit;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.CreditRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.service.CreditService;
import pl.sda.poznan.bank.backend.web.viewmodel.CreditVM;

import java.time.LocalDate;

@Service
public class CreditServiceImpl implements CreditService {

    private BankAccountRepository bankAccountRepository;
    private UserRepository userRepository;
    private CreditRepository creditRepository;
    private InterestServiceImpl interestService;


    @Autowired
    public CreditServiceImpl(BankAccountRepository bankAccountRepository, UserRepository userRepository, CreditRepository creditRepository, InterestServiceImpl interestService) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
        this.creditRepository = creditRepository;
        this.interestService = interestService;
    }

    @Transactional(rollbackFor = OperationException.class)
    @Override
    public Boolean getCredit(CreditVM viewModel, long id) {

        String myAccountNumber = viewModel.getSourceAccountNumber();
        BankAccount Account = bankAccountRepository.findByAccountNumber(myAccountNumber);

        if (!(Account.getAccountType().equals(AccountType.PREMIUM))) {
            throw new OperationException("Nie mozna przydzielic kredytu");
        }

        Credit credit = new Credit();

        String startCreditDateBeforeParsing = viewModel.getStartCreditDate();
        LocalDate startCreditDate = LocalDate.parse(startCreditDateBeforeParsing);
        credit.setStartCreditDate(startCreditDate);

        String endCreditDateBeforeParsing = viewModel.getEndCreditDate();
        LocalDate endCreditDate = LocalDate.parse(endCreditDateBeforeParsing);
        credit.setEndCreditDate(endCreditDate);

        double creditBalance= Double.parseDouble(viewModel.getCreditBalance());
        credit.setCreditBalance(creditBalance);

        int installment = Integer.parseInt(viewModel.getInstallment());
        credit.setInstallment(installment);

        credit.setUser(userRepository.findById(id).orElse(null));

        creditRepository.save(credit);

        return true;
    }

//    @Scheduled(cron = "0 0 8 10 * ?")
@Override
public void CreditInstallment(long id){
    Credit credit = creditRepository.findOne(id);
    Double creditBalance = credit.getCreditBalance();
    Double interestValue = interestService.credtInterestCounter(credit);
    creditBalance -= creditBalance / interestValue;

    }


}

