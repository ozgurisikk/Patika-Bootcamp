package com.exercise.rest.business.abstracts;

import com.exercise.rest.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer getById(int id);

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete (int id);

    List<Customer> findAll();
}
