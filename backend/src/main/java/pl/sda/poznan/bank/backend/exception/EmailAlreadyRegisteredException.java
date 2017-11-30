package pl.sda.poznan.bank.backend.exception;

public class EmailAlreadyRegisteredException extends SdaBankApplicationException {
    public EmailAlreadyRegisteredException() {
        super("Email Already Registered");
    }

    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }

    public EmailAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }
}
