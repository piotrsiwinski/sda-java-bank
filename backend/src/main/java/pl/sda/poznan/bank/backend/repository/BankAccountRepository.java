package pl.sda.poznan.bank.backend.repository;

import bank.labs.model.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
