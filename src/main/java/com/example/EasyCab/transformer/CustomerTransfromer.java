package com.example.EasyCab.transformer;

import com.example.EasyCab.dto.request.CustomerRequest;
import com.example.EasyCab.dto.response.CustomerResponse;
import com.example.EasyCab.model.Customer;

public class  CustomerTransfromer {
    public static Customer  CustomerRequestToCustomer(CustomerRequest customerRequest){
//        Customer customer=new Customer();
//        customer.setName(customerRequest.getName());
//        customer.setAge(customerRequest.getAge());
//        customer.setEmailId(customerRequest.getEmailId());
//        customer.setGender(customerRequest.getGender());
        //builder
        Customer customer =Customer.builder().name(customerRequest.getName()).age(customerRequest.getAge()).emailId(customerRequest.getEmailId()).gender(customerRequest.getGender()).build();
        return customer;
    }

    public static CustomerResponse CustomerToCustomerResponse(Customer customer){
        CustomerResponse customerResponse=new CustomerResponse();

        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        customerResponse.setEmailId((customer.getEmailId()));

        return  customerResponse;
    }

}
