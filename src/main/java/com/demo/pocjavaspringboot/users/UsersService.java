package com.demo.pocjavaspringboot.users;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.demo.pocjavaspringboot.users.dtos.CreateUserDto;

@Service
public class UsersService {

    // @Autowired private UsersRepository usersRepository; // Alternative to create constructor
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;  
    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    // Create User
    public UserEntity createUser(CreateUserDto req) {
        UserEntity newUser = modelMapper.map(req, UserEntity.class);
        // ----------------- if not used modelmapper, follow below method   
        // var newUser = UserEntity.builder()
        //     .userName(req.getUserName())
        //     .email(req.getEmail())
        //     // .password(req.getPassword())
        //     .build();
        
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
    public UserEntity loginUser(String userName, String password) {
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
