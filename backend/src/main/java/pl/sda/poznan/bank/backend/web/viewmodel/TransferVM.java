package pl.sda.poznan.bank.backend.web.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransferVM {
    private String title;

    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private double amount;
    private String notes;
    private String address;

}
