package com.demo.pocjavaspringboot.users;

import org.springframework.stereotype.Service;

import com.demo.pocjavaspringboot.users.dtos.CreateUserDto;

@Service
public class UsersService {

    // @Autowired private UsersRepository usersRepository; // Alternative to create constructor
    private final UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Create User
    public UserEntity createUser(CreateUserDto req) {
        var newUser = UserEntity.builder()
            .userName(req.getUserName())
            .email(req.getEmail())
            // .password(req.getPassword())
            .build();
        
        return usersRepository.save(newUser);
    }

    // Get User
    public UserEntity getUser(String userName) {
        return usersRepository.findByUserName(userName)
            .orElseThrow(() -> new UserNotFoundException(userName));
    }

    public UserEntity getUser(Long userId) {
        return usersRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException(userId));
    }

    // Get My Profile
    public UserEntity getMyProfile(String userName, String password) {
        return usersRepository.findByUserName(userName)
            .orElseThrow(() -> new UserNotFoundException(userName));
    }   

        public static class UserNotFoundException extends IllegalArgumentException{
            public UserNotFoundException(String userName) {
                super("User " + userName + " not found!");
            }
            public UserNotFoundException(Long userId) {
                super("User " + userId + " not found!");
            }
        }
}
