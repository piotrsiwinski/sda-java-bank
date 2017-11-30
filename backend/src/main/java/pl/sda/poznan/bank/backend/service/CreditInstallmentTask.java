package pl.sda.poznan.bank.backend.service;

        import org.springframework.stereotype.Service;
        import pl.sda.poznan.bank.backend.model.Credit;
        import pl.sda.poznan.bank.backend.repository.CreditRepository;
        import pl.sda.poznan.bank.backend.service.impl.InterestServiceImpl;


public class CreditInstallmentTask implements Runnable {

    private CreditRepository creditRepository;
    private InterestServiceImpl interestService;

    private long id;

    public CreditInstallmentTask(long id,CreditRepository creditRepository, InterestServiceImpl interestService) {
        this.id = id;
        this.creditRepository = creditRepository;
        this.interestService = interestService;
    }

    @Override
    public void run() {
        Credit credit = creditRepository.findOne(id);
        Double creditBalance = credit.getCreditBalance();
        Double interestValue = interestService.creditInterestCounter(credit);
        creditBalance -= creditBalance / interestValue;
    }
}
