package com.example.tregbootrest.initDB;

import com.example.tregbootrest.entity.Car;
import com.example.tregbootrest.entity.User;
import com.example.tregbootrest.service.CarService;
import com.example.tregbootrest.service.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitDb {
    private final UserServiceImpl userService;
    private final CarService carService;

    @Autowired
    public InitDb(UserServiceImpl userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }

    @PostConstruct
    public void postConstruct() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            Car VWCar = new Car("VW", "POLO");
            Car BMWCar = new Car("BMW", "X3");


User user1 = new User ("mik", "aza", 37);
            //user1.addCarToUser(VWCar);
            ///user1.addCarToUser(BMWCar);
User user2 = new User ("nik", "nikki", 22);
            //user2.addCarToUser(VWCar);
User user3 = new User ("pavel", "mihaduk", 45);
           //user3.addCarToUser(BMWCar);
            userService.createUser(user1);
            userService.createUser(user2);
            userService.createUser(user3);


        }
    }
}
