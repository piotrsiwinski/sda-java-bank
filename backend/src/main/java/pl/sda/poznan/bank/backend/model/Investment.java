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

public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startInvestmentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endInvestmentDate;
    @ManyToOne
    private User user;
    private Double investmentBalance;

    private Double interest;

}

