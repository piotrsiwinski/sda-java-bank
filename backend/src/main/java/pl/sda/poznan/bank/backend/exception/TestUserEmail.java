package pl.sda.poznan.bank.backend.exception;

import pl.sda.poznan.bank.backend.service.UserService;

public class TestUserEmail {

    private UserService userService;

    public boolean UserEmailAlreadyRegistered(String UserEmail){
        if (userService.findUserByEmail(UserEmail) == null){
            return false;
        } else {
            return true;
        }
    }
}
