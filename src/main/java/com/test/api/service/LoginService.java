package com.test.api.service;

import com.test.api.BadRequestException;
import com.test.api.LoginResponse;
import com.test.api.request.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface LoginService {

    public ResponseEntity<LoginResponse> login(LoginRequest request) throws BadRequestException;
}
