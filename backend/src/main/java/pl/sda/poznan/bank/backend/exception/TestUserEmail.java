package pl.sda.poznan.bank.backend.exception;

import pl.sda.poznan.bank.backend.service.UserService;

public class TestUserEmail {

    private static UserService userService;

    static void TestUserEmailAlreadyRegistered(String UserEmail) throws UserException{
        if (userService.findUserByEmail(UserEmail) != null){
          throw new UserException("Email already existing");
        }
    }
}
