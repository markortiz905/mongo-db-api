package com.system.customer.controllers;

import com.system.customer.entities.Customer;
import com.system.customer.exception.BadRequestServiceException;
import com.system.customer.exception.CustomerServiceException;
import com.system.customer.services.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class CustomerRestController {

    private static final Logger logger = LogManager.getLogger(CustomerRestController.class);

    @Autowired private CustomerService customerService;

    @PostMapping("/customer/create/firstName/{firstName}/lastName/{lastName}/dob/{dob}/email/{email}/gender/{gender}/address/{address}/city/{city}")
    Customer newCustomer(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String dob, @PathVariable String email,
                         @PathVariable String gender, @PathVariable String address, @PathVariable String city) throws CustomerServiceException, BadRequestServiceException {
        DateTimeFormatter newPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Customer newCustomer = new Customer(firstName, lastName, dob, email, gender, address, city, LocalDateTime.now().format(newPattern), LocalDateTime.now().format(newPattern));
        customerService.create(newCustomer);
        return newCustomer;
    }

    @GetMapping("/customer/search/firstName/{firstName}")
    List<Customer> findCustomerByFirstName(@PathVariable String firstName) throws CustomerServiceException {
        logger.info("txnState=start");
        List<Customer> list = customerService.findCustomerByFirstName(firstName);
        logger.info("txnState=end");
        return list;
    }
}
