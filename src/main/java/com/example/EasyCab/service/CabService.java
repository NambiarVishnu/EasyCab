package com.example.EasyCab.service;

import com.example.EasyCab.dto.request.CabRequest;
import com.example.EasyCab.dto.response.CabResponse;
import com.example.EasyCab.exception.DriverNotFoundException;
import com.example.EasyCab.model.Cab;
import com.example.EasyCab.model.Driver;
import com.example.EasyCab.repository.DriverRepository;
import com.example.EasyCab.transformer.CabTransfromer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;
    public CabResponse registerCab(CabRequest cabRequest, int driverId) {
        Optional<Driver> optionalDriver =driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid Driver id");
        }
        Driver driver =optionalDriver.get();
        Cab cab= CabTransfromer.cabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver=driverRepository.save(driver);

        return CabTransfromer.cabToCabResponse(savedDriver.getCab(),savedDriver);
    }
}
