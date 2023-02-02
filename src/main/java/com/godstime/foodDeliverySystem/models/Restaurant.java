package com.godstime.foodDeliverySystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//import java.awt.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String cuisine;
    @NotNull
    private String phoneNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<MenuItem> menu;

    // getters and setters
}
