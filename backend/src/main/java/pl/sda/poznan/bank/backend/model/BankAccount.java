package pl.sda.poznan.bank.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BankAccount {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    private User user;

    private double balance;

    public BankAccount() {
    }

    public BankAccount(AccountType accountType, User user) {
        this.accountType = accountType;
        this.user = user;
        this.balance = 0;
    }

}