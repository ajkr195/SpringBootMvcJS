package com.spring.boot.rocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.rocks.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
