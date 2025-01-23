package com.example.EasyCab.service;

import com.example.EasyCab.dto.request.DriverRequest;
import com.example.EasyCab.dto.response.DriverResponse;
import com.example.EasyCab.model.Driver;
import com.example.EasyCab.repository.DriverRepository;
import com.example.EasyCab.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;
    public DriverResponse addDriver(DriverRequest driverRequest) {
        Driver driver= DriverTransformer.driverRequestToDriver(driverRequest);
        Driver savedDriver=driverRepository.save(driver);
      return DriverTransformer.driverToDriverResponse(savedDriver);
    }
}
