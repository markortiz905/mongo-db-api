package com.system.customer.entities;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String gender;
    private String address;
    private String city;
    private String dateCreated;
    private String dateUpdated;

    public Customer(String firstName, String lastName, String dob, String email,
                    String gender, String address, String city, String dateCreated,
                    String dateUpdated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && firstName.equals(customer.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateUpdated='" + dateUpdated + '\'' +
                '}';
    }
}
