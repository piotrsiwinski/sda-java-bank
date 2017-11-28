package pl.sda.poznan.bank.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.Investment;
import pl.sda.poznan.bank.backend.repository.InvestmentRepository;
import pl.sda.poznan.bank.backend.service.InvestmentService;

import java.util.List;


@Service
public class InvestmentServiceImpl implements InvestmentService {
    private InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentServiceImpl(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public Investment findInvestment(Long id) {

        return investmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Investment with this id doesn't exist"));
    }

    public List<Investment> findAllInvestments() {
        return investmentRepository.findAll();
    }

    public void saveInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public void removeInvestment(Long id) {
        investmentRepository.delete(id);
    }

    public void updateInvestment(Long id, Investment newInvestment) {
        Investment oldInvestment = investmentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Investment with this id doesn't exist"));
        oldInvestment.setUser(newInvestment.getUser());
        oldInvestment.setInterest(newInvestment.getInterest());
        oldInvestment.setStartInvestmentDate(newInvestment.getStartInvestmentDate());
        oldInvestment.setEndInvestmentDate(newInvestment.getEndInvestmentDate());
        oldInvestment.setInvestmentBalance(newInvestment.getInvestmentBalance());
    }

}
