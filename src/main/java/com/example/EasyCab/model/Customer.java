package com.example.EasyCab.model;

import com.example.EasyCab.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Customer {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String name;

    private int age;

    private String emailId;

    private Gender gender;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name="customer_id")
    List<Booking> bookings =new ArrayList<>();
}
