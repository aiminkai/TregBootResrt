package com.example.tregbootrest.controller;

import com.example.tregbootrest.entity.Car;
import com.example.tregbootrest.entity.Status;
import com.example.tregbootrest.entity.User;
import com.example.tregbootrest.service.CarService;
import com.example.tregbootrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserRestController {

    private final UserService userService;
    private final CarService carService;

    @Autowired
    public UserRestController(UserService userService, CarService carService) {
        this.userService = userService;

        this.carService = carService;
    }

    @GetMapping("/")
    public List<User> showAllUsers () throws IOException {
        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> gerUserById(@PathVariable int id) {
        //try {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);

     //   } catch (EntityNotFoundException e) {
          //  throw new EntityNotFoundException("not found");
       // }
    }
    @PostMapping("/")
    public User createUser (@RequestBody User user){

        user.setStatus(Status.SOLD);
        userService.createUser(user);
       // user.addCarToUser(new Car("car_test", "car_test"));
        return user;
    }

    @PutMapping("/")
    public User updateUser (@RequestBody User user){
       // user.addCarToUser(new Car("test", "test"));
        userService.createUser(user);
        return user;
    }

    @DeleteMapping ("/{id}")
    public String deleteUser (@PathVariable int id){
        userService.deleteUser(id);
        return "deleted";
    }

    @GetMapping("/find/{name}/{age}")
    public List <User> findByNameAndAge (@PathVariable String name, @PathVariable int age){
        return userService.findUserByNameAndAgeAfter(name, age);
    }


}
