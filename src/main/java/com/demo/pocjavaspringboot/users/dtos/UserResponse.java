package com.demo.pocjavaspringboot.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
 
    private Long id;

  
    private String userName;


    private String email;


    private String bio;

    private String imageUrl;
}
