package com.demo.pocjavaspringboot.users.dtos;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class CreateUserDto {

    @NonNull
    private String userName;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
