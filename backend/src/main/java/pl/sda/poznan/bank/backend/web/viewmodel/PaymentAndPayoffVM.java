package pl.sda.poznan.bank.backend.web.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PaymentAndPayoffVM {

    @NotNull
    private String sourceAccountNumber;
    @NotNull
    private double amount;
    private String notes;


}
