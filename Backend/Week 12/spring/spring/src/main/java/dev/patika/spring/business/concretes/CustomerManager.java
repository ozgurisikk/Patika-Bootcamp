package dev.patika.spring.business.concretes;

import dev.patika.spring.Customer;
import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dao.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;

    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer getById(int id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        this.customerRepo.delete(customer);
    }

    @Override
    public Customer update(Customer customer) {
        if (customer.getId() == 0){
            throw new RuntimeException("Enter a valid customer");
        }
        return this.customerRepo.save(customer);
    }
}
