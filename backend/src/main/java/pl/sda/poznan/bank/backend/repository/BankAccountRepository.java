package pl.sda.poznan.bank.backend.repository;


import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.User;

import java.util.List;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {

   BankAccount findByAccountNumber(String AccountNumber);
   List<BankAccount>  findAllByUser(User user);

}
