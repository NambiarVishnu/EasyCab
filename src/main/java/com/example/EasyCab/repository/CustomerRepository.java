package com.example.EasyCab.repository;

import com.example.EasyCab.Enum.Gender;
import com.example.EasyCab.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findByGender(Gender gender);

    @Query("select c from Customer c where c.gender=:gender and c.age>:age")
    List<Customer> getAllByGenderAndAgeGreaterThan(@Param("gender") Gender gender,
    @Param("age")int age);


}
