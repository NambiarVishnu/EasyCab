package com.example.EasyCab.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabResponse {

    private String cabNumber;

    private String cabModel;

    private double perKmRate;

    private boolean available;

    private DriverResponse driver;
}
