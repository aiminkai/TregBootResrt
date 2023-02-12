package com.example.tregbootrest.service;

import com.example.tregbootrest.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers ();
    public User getUserById(long id);
    public void createUser(User user);
    public void deleteUser(long id);
    public List<User> findUserByNameAndAgeAfter (String name, long age);
}
