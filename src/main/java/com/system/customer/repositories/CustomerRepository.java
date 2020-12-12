package com.system.customer.repositories;

import com.system.customer.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{firstName: { $regex: ?0 } }")
    List<Customer> findByFirstName(String firstName);
}
