package pl.sda.poznan.bank.backend.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sda.poznan.bank.backend.model.BankAccount;
import pl.sda.poznan.bank.backend.model.User;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    BankAccount findById(long id);
    BankAccount findByUser(User user);

}
