package com.ishan.todolist.Service;

import com.ishan.todolist.Repository.UserRepository;
import com.ishan.todolist.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> createUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>("user created successfully", HttpStatus.CREATED);
    }
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<User> updateUser(User user) {
        User usr = userRepository.findById(user.getUserId()).orElseThrow(()-> new RuntimeException("User not found."));
        usr.setUsername(user.getUsername());
        userRepository.save(usr);
        return new ResponseEntity<>(usr, HttpStatus.OK);
    }
    public ResponseEntity<String> deleteUser(int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
