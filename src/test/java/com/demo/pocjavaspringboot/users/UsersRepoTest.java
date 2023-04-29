package com.demo.pocjavaspringboot.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class UsersRepoTest {
    
    @Autowired
    private UsersRepository usersRepository;

    @Test
    @Order(1)
    void canCreateUser() {

        new UserEntity();
        var user = UserEntity.builder()
            .id((long) 66)
            .userName("Bruce Wayne")
            .email("bruce@java.com")
            .build();

        usersRepository.save(user);
    }   

    @Test
    @Order(2)
    void canFindUsers() {
        new UserEntity();
        var user = UserEntity.builder()
            .id((long) 66)
            .userName("Bruce Wayne")
            .email("bruce@java.com")
            .build();

        usersRepository.save(user);

        var users = usersRepository.findAll();
        Assertions.assertEquals(1, users.size());
    }
}
