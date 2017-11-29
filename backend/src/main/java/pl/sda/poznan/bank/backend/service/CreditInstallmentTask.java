package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.Credit;

public class CreditInstallmentTask implements Runnable {
    private Long id;

    public CreditInstallmentTask(Long id) {
        this.id = id;
    }

    @Override
    public void run() {
        Credit credit = creditRepository.findOne(id);
        Double creditBalance = credit.getCreditBalance();
        Double interestValue = interestService.credtInterestCounter(credit);
        creditBalance -= creditBalance / interestValue;
    }
}
