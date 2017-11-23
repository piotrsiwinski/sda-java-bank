package pl.sda.poznan.bank.backend.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.Investment;

public interface InvestmentRepository extends CrudRepository<Investment, Long>{
    Investment findById(Long id);
}
