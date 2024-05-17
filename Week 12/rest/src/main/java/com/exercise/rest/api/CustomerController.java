package com.exercise.rest.api;

import com.exercise.rest.business.abstracts.CustomerService;
import com.exercise.rest.dto.response.CustomerResponse;
import com.exercise.rest.dto.request.CustomerSaveRequest;
import com.exercise.rest.dto.request.CustomerUpdateRequest;
import com.exercise.rest.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {
    private CustomerService customerService;

    private ModelMapper modelMapper;


    public CustomerController(CustomerService customerService, ModelMapper modelMapper) { // IOC DEPENDENCY INJECTION
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll(){

       /* List<CustomerDto> customerDtoList = this.customerService.findAll().stream().map(
                customer -> this.converter.convertDto(customer)
        ).collect(Collectors.toList());

        *///Model mapper kullanimi
        List<CustomerResponse> customerResponseList = this.customerService.findAll().stream().map(
                customer -> this.modelMapper.map(customer, CustomerResponse.class)).collect(Collectors.toList());

        return customerResponseList;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest){ // burdaki request body bize json olarak gelen customer bilgisini customer objesi olarak duzenleyip buraya gonderiyor thx spring
        Customer newCustomer = this.modelMapper.map(customerSaveRequest, Customer.class);
        newCustomer.setOnDate(LocalDate.now());
        return this.customerService.save(newCustomer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest){
        Customer updatedCustomer = this.customerService.getById(customerUpdateRequest.getId());
        updatedCustomer.setName(customerUpdateRequest.getName());
        updatedCustomer.setGender(customerUpdateRequest.getGender());
        return this.customerService.update(updatedCustomer);
    }

    @DeleteMapping("customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        this.customerService.delete(id);
    }

    @GetMapping("customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") int id){
        return this.modelMapper.map(this.customerService.getById(id), CustomerResponse.class);
    }
}
