package com.demo.pocjavaspringboot.users.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserReqDto {
    private String userName;
    private String password;
}
