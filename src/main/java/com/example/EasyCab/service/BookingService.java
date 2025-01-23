package com.example.EasyCab.service;

import com.example.EasyCab.dto.request.BookingRequest;
import com.example.EasyCab.dto.response.BookingResponse;
import com.example.EasyCab.exception.CabUnavailableException;
import com.example.EasyCab.exception.CustomerNotFoundException;
import com.example.EasyCab.model.Booking;
import com.example.EasyCab.model.Cab;
import com.example.EasyCab.model.Customer;
import com.example.EasyCab.model.Driver;
import com.example.EasyCab.repository.BookingRepository;
import com.example.EasyCab.repository.CabRepository;
import com.example.EasyCab.repository.CustomerRepository;
import com.example.EasyCab.repository.DriverRepository;
import com.example.EasyCab.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    CabRepository cabRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CustomerRepository customerRepository;
    public BookingResponse bookCab(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException(("Invalid Customer id"));
        }
        Customer customer=optionalCustomer.get();
        Cab availableCab=cabRepository.getAvailableCabRandomly();
        if(availableCab==null){
            throw new CabUnavailableException("Sorry!No cab found");

        }

        Booking booking= BookingTransformer.bookingRequestToBooking(bookingRequest,availableCab.getPerKmRate());
        Booking savedBooking =bookingRepository.save(booking);
        availableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);
        Driver driver=driverRepository.getDriverByCabId(availableCab.getCabId());

        driver.getBookings().add(savedBooking);
         Customer savedCustomer =customerRepository.save(customer);
         Driver savedDriver=driverRepository.save(driver);
         return BookingTransformer.bookingToBookingResponse(savedBooking,availableCab,savedDriver,savedCustomer);

    }
}
