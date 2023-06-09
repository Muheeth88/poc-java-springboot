package com.demo.pocjavaspringboot.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByUserName(String userName);
    
}