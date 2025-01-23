package com.example.EasyCab.transformer;

import com.example.EasyCab.dto.request.CabRequest;
import com.example.EasyCab.dto.response.CabResponse;
import com.example.EasyCab.model.Cab;
import com.example.EasyCab.model.Driver;

public class CabTransfromer {
    public static Cab cabRequestToCab(CabRequest cabRequest){
        return Cab.builder().cabNumber(cabRequest.getCabNumber())
                .cabModel(cabRequest.getCabModel())
                .perKmRate(cabRequest.getPerKmRate())
                .available(true).build();

    }

    public static CabResponse cabToCabResponse(Cab cab, Driver driver){
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .perKmRate(cab.getPerKmRate())
                .cabModel(cab.getCabModel())
                .available(cab.isAvailable())
                .driver(DriverTransformer.driverToDriverResponse(driver)).build();
    }
}
