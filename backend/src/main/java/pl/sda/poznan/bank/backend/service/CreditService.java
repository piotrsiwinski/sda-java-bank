package pl.sda.poznan.bank.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.poznan.bank.backend.exception.OperationException;
import pl.sda.poznan.bank.backend.model.AccountType;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.Credit;
import pl.sda.poznan.bank.backend.repository.BankAccountRepository;
import pl.sda.poznan.bank.backend.repository.CreditRepository;
import pl.sda.poznan.bank.backend.repository.UserRepository;
import pl.sda.poznan.bank.backend.web.viewmodel.CreditVM;

import java.time.LocalDate;

@Service
public class CreditService {

    private BankAccountRepository bankAccountRepository;
    private UserRepository userRepository;
    private CreditRepository creditRepository;


    @Autowired
    public CreditService(BankAccountRepository bankAccountRepository, UserRepository userRepository, CreditRepository creditRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
        this.creditRepository = creditRepository;

    }

    @Transactional(rollbackFor = OperationException.class)
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

        credit.setUser(userRepository.findById(id));

        return true;
    }

    @Scheduled(cron = "0 0 8 10 * ?")
    public void CreditInstallment(long id){
        Credit credit = creditRepository.findOne(id);
        Double creditBalance = credit.getCreditBalance();
        creditBalance -= creditBalance/credit.getInterest();
    }


}

