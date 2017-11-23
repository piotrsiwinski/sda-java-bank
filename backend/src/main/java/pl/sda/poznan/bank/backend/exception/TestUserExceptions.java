package pl.sda.poznan.bank.backend.exception;

import pl.sda.poznan.bank.backend.service.UserService;
import pl.sda.poznan.bank.backend.web.viewmodel.UserRegistrationVM;

public class TestUserExceptions {

    private static UserService userService;

    public static void TestUserAlreadyRegistered(UserRegistrationVM userVM) throws UserException {
        if (userService.findUserByEmail(userVM.getEmail()) != null) {
            throw new UserException("Email already existing");
        }
        if (userService.findUserByLogin(userVM.getLogin()) != null) {
            throw new UserException("Login already existing");
        }
    }
}
