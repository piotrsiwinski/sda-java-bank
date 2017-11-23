package pl.sda.poznan.bank.backend.exception;

import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.service.UserService;

public class UserException extends Exception {

    private UserService userService;

    public boolean UserEmailAlreadyRegistered(String UserEmail){
        if (userService.findUserByEmail(UserEmail) == null){
            return false;
        } else {
            return true;
        }
    }
}
