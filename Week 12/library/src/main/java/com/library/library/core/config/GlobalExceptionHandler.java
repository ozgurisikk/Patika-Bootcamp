package com.library.library.core.config;

import com.library.library.core.exception.NotFoundException;
import com.library.library.core.result.Result;
import com.library.library.core.result.ResultData;
import com.library.library.core.utilities.Msg;
import com.library.library.core.utilities.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData> handleValidationErrors(MethodArgumentNotValidException e){
        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream().
                map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ResultData<List<String>> resultData = new ResultData<>(false, Msg.VALIDATE_ERROR, "400",validationErrorList );
        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }
}
