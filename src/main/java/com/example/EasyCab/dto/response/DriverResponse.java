package com.example.EasyCab.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DriverResponse {
        private  int driverId;

        private String name;

        private int age;

        private String emailId;


}

