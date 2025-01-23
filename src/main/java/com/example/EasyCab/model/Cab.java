package com.example.EasyCab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cab {

    @Id
    private int cabId;

    private String cabNumber;

    private String cabModel;

    private double perKmRate;

    private boolean available;

}
