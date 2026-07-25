package com.spring_validation.validation.controller;

import com.spring_validation.validation.dto.UserRequest;
import com.spring_validation.validation.entity.User;
import com.spring_validation.validation.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getAllUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getAllUser(id));
    }
}
