package com.example.EasyCab.controller;

import com.example.EasyCab.dto.request.BookingRequest;
import com.example.EasyCab.dto.response.BookingResponse;
import com.example.EasyCab.dto.response.CabResponse;
import com.example.EasyCab.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingContoller {

    @Autowired
    BookingService bookingService;

    @PostMapping("/customer/{id}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                               @PathVariable("id")int customerId){
        return bookingService.bookCab(bookingRequest,customerId);
    }
}
