package example.micronaut.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

@ControllerAdvice
public class BookNotFoundExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity handleBadRequestAlertException(BookNotFoundException ex,
                                                         NativeWebRequest request) {
        return ResponseEntity.notFound().build();
    }
}
