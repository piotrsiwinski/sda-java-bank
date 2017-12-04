package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.web.viewmodel.CreditVM;

public interface CreditService  {
    Boolean getCredit(CreditVM viewModel, long id);

   Runnable CreditInstallment(long id);
}
