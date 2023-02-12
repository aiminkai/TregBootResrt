package com.example.tregbootrest.service;

import com.example.tregbootrest.entity.Car;


import java.util.List;

public interface CarService {
    public List<Car> getAllCars ();
    public Car getCarById(long id);
    public void createCar(Car car);
    public void deleteCar(long id);
}
