package pl.sda.poznan.bank.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.poznan.bank.backend.model.Investment;
import pl.sda.poznan.bank.backend.model.User;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}