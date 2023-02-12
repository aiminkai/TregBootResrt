package com.example.tregbootrest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Car(String name, String model) {
        this.name = name;
        this.model = model;
    }


}
