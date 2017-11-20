package pl.sda.poznan.bank.backend.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class History {


    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate operationDate;
    private String description;
    @ManyToOne
    private User userId;


    public History(OperationType operationType, LocalDate operationDate, String description) {
        this.operationType = operationType;
        this.operationDate = operationDate;
        this.description = description;

    }

    public History() {
    }
}
