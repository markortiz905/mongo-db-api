package com.system.customer.services;

import com.system.customer.entities.Customer;
import com.system.customer.exception.BadRequestServiceException;
import com.system.customer.exception.CustomerServiceException;
import com.system.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired private CustomerRepository customerRepository;

    public Customer create(String firstName, String lastName, String dob, String email,
                              String gender, String address, String city, String dateCreated,
                              String dateUpdated) throws CustomerServiceException, BadRequestServiceException {
        try {
            return customerRepository.save(new Customer(firstName, lastName, dob, email, gender, address, city, dateCreated, dateUpdated));
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestServiceException(e, "Request Not Completed");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomerServiceException(e, "Failed to create Customer.");
        }
    }

    public Customer create(Customer customer) throws CustomerServiceException, BadRequestServiceException {
        return create(customer.getFirstName(), customer.getLastName(), customer.getDob(), customer.getEmail(),
                customer.getGender(), customer.getAddress(), customer.getCity(), customer.getDateCreated(), customer.getDateUpdated());
    }

    public List<Customer> findCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

}
