package com.demo.pocjavaspringboot.users;

import java.net.URI;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pocjavaspringboot.common.dtos.ErrorResponse;
import com.demo.pocjavaspringboot.users.UsersService.UserNotFoundException;
import com.demo.pocjavaspringboot.users.dtos.CreateUserDto;
import com.demo.pocjavaspringboot.users.dtos.UserResponse;
import com.demo.pocjavaspringboot.users.dtos.LoginUserReqDto;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final ModelMapper modelMapper;
    private final UsersService usersService;

    public UsersController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("")
    ResponseEntity<UserResponse> signupUser(@RequestBody CreateUserDto req) {
        UserEntity savedUser = usersService.createUser(req);
        URI savedUserUri = URI.create("/users/" + savedUser.getId());
        return ResponseEntity.created(savedUserUri).body(modelMapper.map(savedUser, UserResponse.class));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getAllUserById(@PathVariable("id") Long id) {
        UserEntity user = usersService.getUser(id);
        return ResponseEntity.ok(modelMapper.map(user,  UserResponse.class));
    }

    @PostMapping("/login") 
    ResponseEntity<UserResponse> loginUser(@RequestBody LoginUserReqDto req) {
        UserEntity loggedUser = usersService.loginUser(req.getUserName(), req.getPassword());
        return ResponseEntity.ok(modelMapper.map(loggedUser,  UserResponse.class));
    }

    @ExceptionHandler({UsersService.UserNotFoundException.class}) 
    ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception e) {

        String message;
        HttpStatus status;

        if(e instanceof UsersService.UserNotFoundException) {
            message = e.getMessage();
            status = HttpStatus.NOT_FOUND;
        } else {
            message = "Something Went Wrong!";
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        
        ErrorResponse response = ErrorResponse.builder()
        .message(message).build();
        return ResponseEntity.status(status).body(response);
    }
    
}
