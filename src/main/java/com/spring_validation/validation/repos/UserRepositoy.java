package com.spring_validation.validation.repos;

import com.spring_validation.validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository<User,Integer> {
    User findByUserId(int id);
}
