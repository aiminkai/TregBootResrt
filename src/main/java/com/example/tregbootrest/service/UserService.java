package com.example.tregbootrest.service;

import com.example.tregbootrest.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

     List<User> getAllUsers () throws IOException;
     User getUserById(long id);
     void createUser(User user);
     void deleteUser(long id);
     List<User> findUserByNameAndAgeAfter (String name, long age);
}
