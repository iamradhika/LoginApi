package com.test.api.controller;

import com.test.api.BadRequestException;
import com.test.api.LoginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice  extends ResponseEntityExceptionHandler {

@ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<LoginResponse> loginFailed(BadRequestException ex , WebRequest request){
    return new ResponseEntity<LoginResponse>(new LoginResponse(400,"Failure",null,ex.getErrorMessage()), HttpStatus.BAD_REQUEST);
}

}
