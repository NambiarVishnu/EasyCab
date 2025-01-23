package com.example.EasyCab.dto.response;

import com.example.EasyCab.Enum.TripStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    private String pickup;

    private String destination;

    private double tripDistanceInKm;

    TripStatus tripStatus;

    private double billAmount;

    private Date bookedAt;

    private Date lastUpdateAt;

    private CustomerResponse customerResponse;

    private CabResponse cabResponse;

}
