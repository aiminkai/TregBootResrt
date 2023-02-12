package com.example.tregbootrest.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @OneToMany ( mappedBy = "user",  fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Car> cars;

    @Column(name = "seat_slot_status")
    private Status status = Status.AVAILABLE;

    public void addCarToUser (Car car){
        if (cars == null) {
            cars = new ArrayList<>();
        }
        cars.add(car);
        car.setUser(this);
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
