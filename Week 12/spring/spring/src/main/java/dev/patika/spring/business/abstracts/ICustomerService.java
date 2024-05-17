package dev.patika.spring.business.abstracts;

import dev.patika.spring.Customer;

public interface ICustomerService {
    Customer getById(int id);
    Customer save(Customer customer);
    void delete(Customer customer);
    Customer update(Customer customer);

}
