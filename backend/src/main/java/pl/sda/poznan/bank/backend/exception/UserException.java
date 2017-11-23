package pl.sda.poznan.bank.backend.exception;

import pl.sda.poznan.bank.backend.model.User;
import pl.sda.poznan.bank.backend.service.UserService;

public class UserException extends Exception {

    public UserException(String message) {
        super(message);
    }

}
