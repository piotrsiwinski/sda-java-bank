package pl.sda.poznan.bank.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    private  long accountNumber;

    public BankAccount() {
    }

    public BankAccount(AccountType accountType, User user, long accountNumber) {
        this.accountType = accountType;
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }



}