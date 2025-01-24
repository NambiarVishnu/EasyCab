package com.example.EasyCab.transformer;

import com.example.EasyCab.Enum.TripStatus;
import com.example.EasyCab.dto.request.BookingRequest;
import com.example.EasyCab.dto.response.BookingResponse;
import com.example.EasyCab.model.Booking;
import com.example.EasyCab.model.Cab;
import com.example.EasyCab.model.Customer;
import com.example.EasyCab.model.Driver;

public class BookingTransformer {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, double perKmRate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.STARTED)
                .billAmount(bookingRequest.getTripDistanceInKm()*perKmRate).build();


    }

    public static BookingResponse bookingToBookingResponse(Booking booking, Cab cab, Driver driver, Customer customer){
        return BookingResponse.builder().
        pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripStatus(booking.getTripStatus())
                        .billAmount(booking.getBillAmount())
                                .bookedAt(booking.getBookedAt())
                .lastUpdateAt(booking.getLastUpdateAt())
                        .customer(CustomerTransfromer.CustomerToCustomerResponse(customer))
                .cab(CabTransfromer.cabToCabResponse(cab,driver)).build();
    }
}
