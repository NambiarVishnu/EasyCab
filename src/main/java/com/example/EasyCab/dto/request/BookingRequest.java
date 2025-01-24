package com.example.EasyCab.dto.request;

import com.example.EasyCab.Enum.TripStatus;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingRequest {
    private String pickup;

    private String destination;

    private double tripDistanceInKm;
    private TripStatus tripStaus;
    private double billAmount;
}
