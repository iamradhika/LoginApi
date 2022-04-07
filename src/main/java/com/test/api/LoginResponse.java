package com.test.api;

import lombok.*;

@Getter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
public class LoginResponse {

    int statusCode;
    String status;
    String token;
    String error;
}
