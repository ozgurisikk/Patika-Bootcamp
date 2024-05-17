package dev.patika.spring.api;

import dev.patika.spring.Customer;
import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.business.concretes.CustomerManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor // customer managaerin costructoru burdan olusturulur
public class CustomerController {
    private final CustomerManager customerManager;


}
