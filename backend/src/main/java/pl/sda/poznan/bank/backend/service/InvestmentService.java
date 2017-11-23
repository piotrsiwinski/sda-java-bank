package pl.sda.poznan.bank.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.sda.poznan.bank.backend.model.Investment;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.repository.InvestmentRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Service
public class InvestmentService {

    private InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public Investment findInvestment(long id) {
        return investmentRepository.findById(id);
    }

    public List<Investment> findAllInvestments() {
        return (List<Investment>) investmentRepository.findAll();
    }

    public void saveInvestment(Investment investment) {
        investmentRepository.save(investment);
    }

    public void removeInvestment(long id) {
        investmentRepository.delete(id);
    }
    public void updateInvestment(long id, Investment newInvestment){
        Investment oldInvestment = investmentRepository.findById(id);
        oldInvestment.setUser(newInvestment.getUser());
        oldInvestment.setInterest(newInvestment.getInterest());
        oldInvestment.setStartInvestmentDate(newInvestment.getStartInvestmentDate());
        oldInvestment.setEndInvestmentDate(newInvestment.getEndInvestmentDate());
        oldInvestment.setInvestmentBalance(newInvestment.getInvestmentBalance());
    }

}
