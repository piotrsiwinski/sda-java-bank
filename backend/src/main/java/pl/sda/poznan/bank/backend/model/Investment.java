package pl.sda.poznan.bank.backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startInvestmentDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endInvestmentDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    private Double investmentBalance;
    @OneToOne
    private Interest interest;

}

