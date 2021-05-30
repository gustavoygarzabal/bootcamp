package com.globant.bootcamp.repository;

import com.globant.bootcamp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByName(String name);

    Optional<User> findOneByEmail(String email);

    void deleteByEmail (String email);

    boolean existsByEmail (String email);
}
