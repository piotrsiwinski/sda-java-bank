package pl.sda.poznan.bank.backend.web.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DepositVM {
    private String accountNumber;
    private Double amount;
}
