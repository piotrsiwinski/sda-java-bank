package pl.sda.poznan.bank.backend.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.sda.poznan.bank.backend.exception.OperationException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

@ControllerAdvice
@Slf4j
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<Object> handleUserNameNotFoundException(final UsernameNotFoundException ex) {
        String bodyOfResponse = "404: The user was not found";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    ResponseEntity<Object> handleSQLException(HttpServletRequest request, Exception ex) {
        String bodyOfResponse = "400: some exception thrown when executing the request.";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TimeoutException.class)
    ResponseEntity<Object> handleTimeOutException(final TimeoutException ex) {
        String bodyOfResponse = "408: The server timed out waiting for the request";
        return new ResponseEntity<>(bodyOfResponse,
                new HttpHeaders(), HttpStatus.REQUEST_TIMEOUT);

    }

    @ExceptionHandler(OperationException.class)
    ResponseEntity<Object> handleTransferException(final OperationException ex) {
        String bodyOfResponse = "400: Transfer error";
        return new ResponseEntity<>(ex.getMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST);

    }


}


