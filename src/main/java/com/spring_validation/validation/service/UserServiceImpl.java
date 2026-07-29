package com.spring_validation.validation.service;

import com.spring_validation.validation.dto.UserRequest;
import com.spring_validation.validation.entity.User;
import com.spring_validation.validation.repos.UserRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
     UserRepositoy userRepositoy;
    public User saveUser(UserRequest userRequest) {
        User mycreatedUser = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .mobile(userRequest.getMobile())
                .gender(userRequest.getGender())
                .age(userRequest.getAge())
                .state(userRequest.getState())
                .build();
        return userRepositoy.save(mycreatedUser);
    }

    public List<User> getAllUser() {
        return userRepositoy.findAll();
    }

    public User getAllUser(int id) {
        return userRepositoy.findByUserId(id);
    }

}

