package com.test.api.request;

import lombok.*;

@Getter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Setter
public class LoginRequest {

    String email;
    String password;
}
