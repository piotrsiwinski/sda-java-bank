package pl.sda.poznan.bank.backend.exception;

import pl.sda.poznan.bank.backend.service.UserService;

public class TestUserLogin {

    private UserService userService;

    public void userLoginAlreadyExists(String UserLogin) throws UserException{
        if(userService.findUserByLogin(UserLogin) != null){
            throw new UserException("Login already existing");
        }
    }
}
