package pl.sda.poznan.bank.backend.aop;


import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.UserException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.sda.poznan.bank.backend.exception.EmailAlreadyRegisteredException;
import pl.sda.poznan.bank.backend.exception.LoginAlreadyRegisteredException;
import pl.sda.poznan.bank.backend.exception.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

@ControllerAdvice
@Slf4j
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<Object> handleUserNameNotFoundException(final UsernameNotFoundException ex) {
        log.error("User not found", ex);
        String bodyOfResponse = "404: The user was not found";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<Object> handleUserNotFoundException(final UsernameNotFoundException ex) {
        log.error("User not found", ex);
        String bodyOfResponse = "404: The user was not found";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    ResponseEntity<Object> handleSQLException(HttpServletRequest request, Exception ex) {
        log.error("An apparent client error", request, ex);
        String bodyOfResponse = "400: The server cannot or will not process the request due to an apparent client error.";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TimeoutException.class)
    ResponseEntity<Object> handleTimeOutException(final TimeoutException ex) {
        log.error("Operation times out", ex);
        String bodyOfResponse = "408: The server timed out waiting for the request";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.REQUEST_TIMEOUT);

    }

    @ExceptionHandler({UserException.class, AuthenticationException.class})
    ResponseEntity<Object> handleConflictException(final UserException ex, AuthenticationException e) {
        log.error("The username already exists", ex, e);
        String bodyOfResponse = "409: Conflict: The username already exists";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NumberFormatException.class)
    ResponseEntity<Object> handleNumberFormatException(NumberFormatException ex) {
        log.error("Format exception", ex);
        String bodyOfResponse = "400: The server cannot or will not process the request due to an apparent client error.";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ResponseEntity<Object> handleEmailAlreadyRegisteredException(EmailAlreadyRegisteredException ex) {
        log.error("EmailAlreadyRegisteredException", ex);
        String bodyOfResponse = "400: This Email is already registered.";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(LoginAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    ResponseEntity<Object> handleLoginAlreadyRegisteredException(LoginAlreadyRegisteredException ex) {
        log.error("EmailAlreadyRegisteredException", ex);
        String bodyOfResponse = "409: This Email is already registered.";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT);
    }


}


