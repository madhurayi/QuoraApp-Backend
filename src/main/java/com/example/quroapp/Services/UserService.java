package com.example.quroapp.Services;

import com.example.quroapp.Repositories.UserRepository;
import com.example.quroapp.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        System.out.println(user.getBio());
        return userRepository.save(user);
    }

    public Optional<User> getUserById(UUID id){
        System.out.println(userRepository.findById(id));
        return userRepository.findById(id);
    }

}
