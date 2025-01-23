package com.example.EasyCab.controller;

import com.example.EasyCab.dto.request.CabRequest;
import com.example.EasyCab.dto.response.CabResponse;
import com.example.EasyCab.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;

    @PostMapping("/register/{id}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,
                                   @PathVariable("id")int driverId){
        return cabService.registerCab(cabRequest,driverId);
    }
}
