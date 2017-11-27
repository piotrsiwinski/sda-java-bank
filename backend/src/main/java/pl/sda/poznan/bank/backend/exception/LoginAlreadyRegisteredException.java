package pl.sda.poznan.bank.backend.exception;

public class LoginAlreadyRegisteredException extends SdaBankApplicationException{
    public LoginAlreadyRegisteredException(String message) {
        super(message);
    }

    public LoginAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
