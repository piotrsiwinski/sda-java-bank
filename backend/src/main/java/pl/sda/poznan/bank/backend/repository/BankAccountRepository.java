package pl.sda.poznan.bank.backend.repository;


import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

   BankAccount findByAccountNumber(String AccountNumber);

}
