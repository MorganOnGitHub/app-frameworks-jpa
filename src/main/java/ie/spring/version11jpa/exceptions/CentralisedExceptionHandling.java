package ie.spring.version11jpa.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class CentralisedExceptionHandling {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleHttpMessageNotReadableException() {
        Map<String, String> map = new HashMap<>();
        map.put("time", LocalDateTime.now().toString());
        map.put("code", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        map.put("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        map.put("message", "Check your JSON");
        return map;
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoSuchElementException(NotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("time", LocalDateTime.now().toString());
        map.put("code", String.valueOf(HttpStatus.NOT_FOUND.value()));
        map.put("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
        map.put("message", "No such element exists!");
        return map;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundException(NotFoundException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("time", LocalDateTime.now().toString());
        map.put("code", String.valueOf(HttpStatus.NOT_FOUND.value()));
        map.put("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
        map.put("message", "Result not found!");
        return map;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {errors.put(error.getField(), error.getDefaultMessage());});
        Map<String, Object> map = new HashMap<>();
        map.put("time", LocalDateTime.now().toString());
        map.put("code", String.valueOf(HttpStatus.BAD_REQUEST.value()));
        map.put("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        map.put("message", errors);
        return map;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("time", LocalDateTime.now().toString());
        map.put("code", String.valueOf(HttpStatus.CONFLICT.value()));
        map.put("reason", HttpStatus.CONFLICT.getReasonPhrase());
        map.put("message", "There is a conflict (entry already exists)!");
        return map;
    }

}