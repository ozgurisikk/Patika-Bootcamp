package com.exercise.rest.dto.request;

import com.exercise.rest.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSaveRequest {

    private String name;
    private String mail;
    private Customer.Gender gender;
}
