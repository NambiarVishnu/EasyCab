package com.example.EasyCab.service;

import com.example.EasyCab.Enum.Gender;
import com.example.EasyCab.dto.request.CustomerRequest;
import com.example.EasyCab.dto.response.CustomerResponse;
import com.example.EasyCab.exception.CustomerNotFoundException;
import com.example.EasyCab.model.Customer;
import com.example.EasyCab.repository.CustomerRepository;


import com.example.EasyCab.transformer.CustomerTransfromer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.EasyCab.transformer.CustomerTransfromer.CustomerToCustomerResponse;


@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        //Request entity to dto
//        Customer customer=new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setGender(customerRequest.getGender());

        Customer customer=CustomerTransfromer.CustomerRequestToCustomer(customerRequest);

        //save the entity into db
        Customer savedCustomer= customerRepository.save(customer);

        //Saved entity to respnse dto
//        CustomerResponse customerResponse=new CustomerResponse();
//
//        customerResponse.setName(savedCustomer.getName());
//        customerResponse.setAge(savedCustomer.getAge());
//        customerResponse.setEmailId((savedCustomer.getEmailId()));



        return CustomerTransfromer.CustomerToCustomerResponse(customer);
    }

    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer id");
        }
        Customer savedCustomer=optionalCustomer.get();

//        CustomerResponse customerResponse=new CustomerResponse();
//        customerResponse.setName(savedCustomer.getName());
//        customerResponse.setAge(savedCustomer.getAge());
//        customerResponse.setEmailId((savedCustomer.getEmailId()));


        return CustomerTransfromer.CustomerToCustomerResponse(savedCustomer);

    }


    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer> customers=customerRepository.findByGender(gender);

        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransfromer.CustomerToCustomerResponse((customer)));
        }

        return customerResponses;

    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(Gender gender, int age) {
        List<Customer> customers=customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);

        List<CustomerResponse> customerResponses=new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransfromer.CustomerToCustomerResponse((customer)));
        }

        return customerResponses;

    }
}
