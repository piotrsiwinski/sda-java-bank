package pl.sda.poznan.bank.backend.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.poznan.bank.backend.service.CreditService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private boolean activated;

    private BankAccount bankAccount;

    private CreditService creditService;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany
    private History history;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAccountStart;

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, String email, boolean activated, BankAccount bankAccount, UserType userType) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.bankAccount = bankAccount;
        this.userType = userType;
    }

}
