package com.appLogin.demo.repository;

import java.util.Optional;

import com.appLogin.demo.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;



public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDetails> findByUsername(String username);

}
