package com.example.quroapp.Controller;

import com.example.quroapp.Repositories.UserRepository;
import com.example.quroapp.Services.UserService;
import com.example.quroapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody(required = true) User user) {
          return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById( @PathVariable UUID id) {
        Optional<User> user=userService.getUserById(id);
        if(user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.OK).body("User Not Found");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody User user) {
        Optional<User> user1=userService.getUserById(id);
        if(user1.isPresent()) {
            if(user.getUsername()!=null){
                user1.get().setUsername(user.getUsername());
            }
            if(user.getEmail()!=null){
                user1.get().setEmail(user.getEmail());
            }
            if(user.getBio()!=null){
                user1.get().setBio(user.getBio());
            }
            user1.ifPresent(userRepository::save);
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        }
        return ResponseEntity.status(HttpStatus.OK).body("User Not Found");
    }
}
