package pl.sda.poznan.bank.backend.converter;

import org.springframework.core.convert.converter.Converter;
import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

public class UserRegistrationVmToUserConverter implements Converter<UserRegistrationVM, User> {
    @Override
    public User convert(UserRegistrationVM userRegistrationVM) {
        User user = new User();
        user.setLogin(userRegistrationVM.getLogin());
        user.setFirstName(userRegistrationVM.getFirstName());
        user.setLastName(userRegistrationVM.getLastName());
        user.setEmail(userRegistrationVM.getEmail());
        user.setPassword(userRegistrationVM.getPassword());
        return user;
    }


}
