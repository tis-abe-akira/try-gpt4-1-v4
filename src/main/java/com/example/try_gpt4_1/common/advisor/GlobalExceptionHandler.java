package com.example.try_gpt4_1.common.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.FieldError;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, Object> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.NOT_FOUND.value());
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", "Validation failed");
        error.put("status", HttpStatus.BAD_REQUEST.value());
        var details = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> Map.of(
                        "field", fieldError.getField(),
                        "message", fieldError.getDefaultMessage()))
                .toList();
        error.put("details", details);
        return error;
    }

    @ExceptionHandler(ResponseStatusException.class)
    public Map<String, Object> handleResponseStatus(ResponseStatusException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getReason());
        error.put("status", ex.getStatusCode().value());
        return error;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("message", "データ整合性エラー: 関連する顧客が存在しません、またはDB制約違反です。");
        error.put("status", HttpStatus.BAD_REQUEST.value());
        return error;
    }
}
