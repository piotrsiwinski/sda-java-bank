package pl.sda.poznan.bank.backend.model;

import javax.persistence.*;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne
    private User user;

    private long balance;

    public BankAccount() {
    }

    public BankAccount(AccountType accountType, User user) {
        this.accountType = accountType;
        this.user = user;
        this.balance = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}