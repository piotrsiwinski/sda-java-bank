package pl.sda.poznan.bank.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Interest {

    private Double interestInPercent;
    private LocalDate startDate;
    private LocalDate endDate;
    private Investment investmentBalance;
    private AccountType accountType;
}
