package com.example.tregbootrest.repository;

import com.example.tregbootrest.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
