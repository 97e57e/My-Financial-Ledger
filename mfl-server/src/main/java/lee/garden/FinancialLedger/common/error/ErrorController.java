package lee.garden.FinancialLedger.common.error;

import lee.garden.FinancialLedger.common.error.exception.account.LogInFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(LogInFailedException.class)
    public ResponseEntity handleLoginFailed(LogInFailedException e) {
        ErrorResponse response = new ErrorResponse(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
