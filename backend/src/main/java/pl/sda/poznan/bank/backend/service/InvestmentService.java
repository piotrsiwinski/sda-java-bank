package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.Investment;
import pl.sda.poznan.bank.backend.repository.InvestmentRepository;


import java.util.List;


@Service
public class InvestmentService {


    private InvestmentRepository investmentRepository;


    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public Investment findInvestment(Long id){

        return  investmentRepository
                .findById(id)
               .orElseThrow(() -> new RuntimeException("Investment with this id doesn't exist"));
    }


    public List<Investment> findAllInvestments() {
        return investmentRepository.findAll();
    }

    public void saveInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public void removeInvestment(long id) {
        investmentRepository.delete(id);
    }
    public void updateInvestment(long id, Investment newInvestment){
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
