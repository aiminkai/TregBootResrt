package com.example.tregbootrest.service;

import com.example.tregbootrest.entity.Car;
import com.example.tregbootrest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final CarRepository userRepository;


    @Autowired
    public CarServiceImpl(CarRepository carRepository, CarRepository userRepository) {
        this.carRepository = carRepository;

        this.userRepository = userRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return  carRepository.findAll();
    }

    @Override
    public Car getCarById(long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }


}
