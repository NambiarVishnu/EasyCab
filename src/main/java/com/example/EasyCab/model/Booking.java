package com.example.EasyCab.model;

import com.example.EasyCab.Enum.TripStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int bookingId;

    private String pickup;

    private String destination;

    private double tripDistanceInKm;

    private TripStatus tripStatus;

    private double billAmount;

    @CreationTimestamp
    private Date bookedAt;

    @UpdateTimestamp
    private Date lastUpdateAt;

}
