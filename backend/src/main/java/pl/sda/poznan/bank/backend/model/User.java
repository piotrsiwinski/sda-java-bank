package pl.sda.poznan.bank.backend.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean activated;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccount;


    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "user")
    private List<History> history;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAccountStart;


}
