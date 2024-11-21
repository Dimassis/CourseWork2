package sky.pro.CourseWork2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(QuestionIsNotFoundException.class)
    public ResponseEntity<String> handleQuestionIsNotFoundException(QuestionIsNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(WrongAmountQuestionException.class)
    public ResponseEntity<String> handleWrongAmountQuestionException(WrongAmountQuestionException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
