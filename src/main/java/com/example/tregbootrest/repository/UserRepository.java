package com.example.tregbootrest.repository;

import com.example.tregbootrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findUserByNameAndAgeAfter (String name, long age);
}
