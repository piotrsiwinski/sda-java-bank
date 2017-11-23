package pl.sda.poznan.bank.backend.exception;

import pl.sda.poznan.bank.backend.service.UserService;

public class TestUserLogin {

    private UserService userService;

    public boolean userLoginAlreadyExists(String UserLogin){
        if(userService.findUserByLogin(UserLogin) == null){
            return false;
        }else {
            return true;
        }
    }
}
