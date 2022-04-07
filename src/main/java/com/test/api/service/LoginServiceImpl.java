package com.test.api.service;

import com.test.api.BadRequestException;
import com.test.api.LoginResponse;
import com.test.api.request.LoginRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceImpl implements LoginService{

    private  RestTemplate restTemplate = new RestTemplate();

    @Getter
  //  @Value("${app.url}")
    private String url = "https://reqres.in/api/login";

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest request) throws BadRequestException {
        HttpEntity<Object> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<LoginResponse> responseEntity;
        try{
            responseEntity = restTemplate.postForEntity(url,request,LoginResponse.class);}
        catch (Exception e){
            throw new BadRequestException("Missing Password");
        }
        return new ResponseEntity<LoginResponse>(responseMapper(responseEntity), HttpStatus.OK);
    }

    public LoginResponse responseMapper(ResponseEntity<LoginResponse> responseEntity){
        LoginResponse response;

             response = new LoginResponse(responseEntity.getStatusCodeValue(),
                    "Success" ,
                    responseEntity.getBody().getToken(), null);
        return response;
    }
}
