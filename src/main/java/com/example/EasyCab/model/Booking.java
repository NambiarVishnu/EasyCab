package com.example.EasyCab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    private int bookingId;

    private String pickup;

    private String destination;

    private double tripDistanceInKm;

    private TripStatus tripStatus;

    private double billAmount;

    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date lastUpdateAt;

}
