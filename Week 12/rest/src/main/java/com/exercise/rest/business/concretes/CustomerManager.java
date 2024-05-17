package com.exercise.rest.business.concretes;

import com.exercise.rest.business.abstracts.CustomerService;
import com.exercise.rest.dao.CustomerRepo;
import com.exercise.rest.entities.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerManager implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = this.getById(id);
        this.customerRepo.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }
}
