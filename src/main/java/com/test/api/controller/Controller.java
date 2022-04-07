package com.test.api.controller;

import com.test.api.BadRequestException;
import com.test.api.LoginResponse;
import com.test.api.request.LoginRequest;
import com.test.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

    @Autowired
    LoginService service;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws BadRequestException {
        return service.login(loginRequest);
    }
}
