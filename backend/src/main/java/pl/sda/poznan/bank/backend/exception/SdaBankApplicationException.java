package pl.sda.poznan.bank.backend.exception;

public class SdaBankApplicationException extends RuntimeException {
    public SdaBankApplicationException(String message) {
        super(message);
    }

    public SdaBankApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
