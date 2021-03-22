package com.example.myshop.repo;

import com.example.myshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User ,Long> {

    User findByUsername(String username);

}
