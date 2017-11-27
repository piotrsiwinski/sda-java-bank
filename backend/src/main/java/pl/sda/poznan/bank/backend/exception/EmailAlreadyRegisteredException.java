package pl.sda.poznan.bank.backend.exception;

public class EmailAlreadyRegisteredException extends SdaBankApplicationException {

    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }

    public EmailAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
