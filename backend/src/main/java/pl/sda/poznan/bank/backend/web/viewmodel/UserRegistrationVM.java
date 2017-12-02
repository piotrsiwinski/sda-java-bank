package pl.sda.poznan.bank.backend.web.viewmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationVM {

    @NotNull
    private String login;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    @Email
    private String email;
    @NonNull
    @Size(min = 8)
    private String password;


    public UserRegistrationVM(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
