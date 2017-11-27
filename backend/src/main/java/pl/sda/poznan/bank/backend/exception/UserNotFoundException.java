package pl.sda.poznan.bank.backend.exception;

public class UserNotFoundException extends SdaBankApplicationException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
