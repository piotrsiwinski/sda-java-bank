package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.Investment;

import java.util.List;

public interface InvestmentService {
    Investment findInvestment(Long id);

    List<Investment> findAllInvestments();

    void saveInvestment(Investment investment);

    void removeInvestment(Long id);

    void updateInvestment(Long id, Investment newInvestment);
}
