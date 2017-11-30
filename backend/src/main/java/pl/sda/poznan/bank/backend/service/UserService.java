package pl.sda.poznan.bank.backend.service;

import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

public interface UserService {

    void saveUser(UserRegistrationVM userVM);
    User findUser(long id);


}
