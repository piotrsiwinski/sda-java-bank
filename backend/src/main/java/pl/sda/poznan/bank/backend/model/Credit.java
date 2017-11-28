package pl.sda.poznan.bank.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startCreditDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endCreditDate;
    @ManyToOne
    private User user;

    private Double creditBalance;

    @OneToOne
    private Interest interest;

    private Integer installment;

}

