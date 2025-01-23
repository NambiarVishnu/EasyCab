package com.example.EasyCab.controller;

import com.example.EasyCab.Enum.Gender;
import com.example.EasyCab.dto.request.CustomerRequest;
import com.example.EasyCab.dto.response.CustomerResponse;
import com.example.EasyCab.model.Customer;
import com.example.EasyCab.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer (@RequestBody CustomerRequest customerRequest){

        return customerService.addCustomer(customerRequest);

    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("get/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender") Gender gender){
        return customerService.getAllByGender(gender);
    }

    @GetMapping("get-by-age-grater-than")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@RequestParam("gender") Gender gender,
                                                                  @RequestParam("age")int age ){
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }



}
