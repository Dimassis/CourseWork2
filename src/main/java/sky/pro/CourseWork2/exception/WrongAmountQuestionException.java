package sky.pro.CourseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongAmountQuestionException extends RuntimeException {
    public WrongAmountQuestionException() {
    }

    public WrongAmountQuestionException(String message) {
        super(message);
    }

    public WrongAmountQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongAmountQuestionException(Throwable cause) {
        super(cause);
    }

    public WrongAmountQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}