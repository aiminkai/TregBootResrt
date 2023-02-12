package com.example.tregbootrest.controller;

import com.example.tregbootrest.entity.Car;
import com.example.tregbootrest.service.CarService;
import com.example.tregbootrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/car")
@RestController
public class CarRestController {
    private final CarService carService;
    private final UserService userService;

    @Autowired
    public CarRestController(CarService carService, UserService userService) {
        this.carService = carService;

        this.userService = userService;
    }

    @GetMapping("/")
    public List<Car> showAllCars (){
        return  carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car gerCarById (@PathVariable int id){
        return carService.getCarById(id);
    }

    @PostMapping("/")
    public Car createCar (@RequestBody Car car){
        carService.createCar(car);
        return car;
    }

    @PutMapping("/")
    public Car updateCar (@RequestBody Car car){
        carService.createCar(car);
        return car;
    }

    @DeleteMapping ("/{id}")
    public String deleteCar (@PathVariable int id){
        carService.deleteCar(id);
        return "deleted";
    }

}
