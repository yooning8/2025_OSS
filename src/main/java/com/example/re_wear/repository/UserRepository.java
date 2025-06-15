package com.example.re_wear.repository;

import com.example.re_wear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
