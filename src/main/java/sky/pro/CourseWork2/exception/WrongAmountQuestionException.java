package sky.pro.CourseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongAmountQuestionException  extends RuntimeException{
    public WrongAmountQuestionException(String message) {
        super(message);
    }
}
