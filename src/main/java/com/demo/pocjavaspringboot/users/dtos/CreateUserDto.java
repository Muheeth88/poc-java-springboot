package com.demo.pocjavaspringboot.users.dtos;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
public class CreateUserDto {

    @NonNull
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
