package com.example.EasyCab.repository;

import com.example.EasyCab.Enum.Gender;
import com.example.EasyCab.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByGender(Gender gender);
}
