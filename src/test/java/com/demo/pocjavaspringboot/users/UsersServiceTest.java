package com.demo.pocjavaspringboot.users;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.demo.pocjavaspringboot.users.dtos.CreateUserDto;

@SpringBootTest
@ActiveProfiles("test")
public class UsersServiceTest {
    @Autowired 
    UsersService usersService;
    
    // @MockBean
    // UsersRepository usersRepository;

    // @Test
    // void canCreateUsers() {
    //     var user = usersService.createUser(new CreateUserDto("Bruce Wayne", "bruce@batman.com", "caped"));
    //     Assertions.assertNotNull(user);
    //     Assertions.assertEquals("Bruce Wayne", user.getUserName());
    // }
}
