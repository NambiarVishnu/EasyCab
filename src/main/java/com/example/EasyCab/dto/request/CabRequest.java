package com.example.EasyCab.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CabRequest {
    private int cabId;

    private String cabNumber;

    private String cabModel;

    private double perKmRate;
}
