package pl.sda.poznan.bank.backend.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.Credit;

public interface CreditRepository extends CrudRepository<Credit, Long> {

}
