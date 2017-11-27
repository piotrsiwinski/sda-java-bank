package pl.sda.poznan.bank.backend.web.viewmodel;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.sda.poznan.bank.backend.model.User;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreditVM {

    @NotNull
    private String sourceAccountNumber;
    @NotNull
    private String amount;
    @NotNull
    @Min(3)
    @Max(36)
    private String numberOfInstallment;
    private String notes;
    @NotNull
    private String startCreditDate;
    @NotNull
    private String endCreditDate;
    @NotNull
    private String creditBalance;
    @NotNull
    private String installment;

    public CreditVM(String sourceAccountNumber, String amount, String numberOfInstallment, String notes, String startCreditDate, String endCreditDate, String creditBalance, String installment) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.amount = amount;
        this.numberOfInstallment = numberOfInstallment;
        this.notes = notes;
        this.startCreditDate = startCreditDate;
        this.endCreditDate = endCreditDate;
        this.creditBalance = creditBalance;
        this.installment = installment;
    }
}
