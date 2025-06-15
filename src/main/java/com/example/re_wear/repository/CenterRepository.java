package com.example.re_wear.repository;

import com.example.re_wear.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CenterRepository extends JpaRepository<Center, Long> {
} 