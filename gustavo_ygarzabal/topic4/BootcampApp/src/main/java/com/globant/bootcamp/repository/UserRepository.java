package com.globant.bootcamp.repository;

import com.globant.bootcamp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);
}
