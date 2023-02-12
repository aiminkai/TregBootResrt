package com.example.tregbootrest.service;

import com.example.tregbootrest.entity.User;
import com.example.tregbootrest.repository.UserRepository;
import com.example.tregbootrest.util.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
       return  userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
            return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void createUser(User user) {

        userRepository.save(user);
        System.out.println(user.getId());

    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findUserByNameAndAgeAfter(String name, long age) {
        return userRepository.findUserByNameAndAgeAfter(name, age);
    }
}
