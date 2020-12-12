package com.system.customer.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.system.customer.entities.Customer;
import com.system.customer.services.CustomerService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

/**
 * I can add more test like this though, just for demonstration only. :)
 */
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void createFamilyVirus() throws Exception {
        Customer customer = new Customer("Rechel Girl", "Ortiz", "2019-06-22 00:00:00",
                "ortizmark905@gmail.com", "Female", "One Oasis Condominium", "Pasig City",
                "2020-11-10 00:00:00", "2020-11-10 00:00:00");
        when(customerService.create(any())).thenReturn(customer);
        this.mockMvc.perform(
                post("/customer/create/firstName/" + "Rechel Girl" +
                        "/lastName/" + "Ortiz" +
                        "/dob/" + "2019-06-22 00:00:00" +
                        "/email/" + "ortizmark905@gmail.com" +
                        "/gender/" + "Female" +
                        "/address/" + "One Oasis Condominium" +
                        "/city/" + "Pasig City")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "   \"id\":null," +
                                "   \"firstName\":\"Rechel Girl\"," +
                                "   \"lastName\":\"Ortiz\"," +
                                "   \"dob\":\"2019-06-22 00:00:00\"," +
                                "   \"email\":\"ortizmark905@gmail.com\"," +
                                "   \"gender\":\"Female\"," +
                                "   \"address\":\"One Oasis Condominium\"," +
                                "   \"city\":\"Pasig City\"," +
                                "   \"dateCreated\":\"2020-12-12 10:49:26\"," +
                                "   \"dateUpdated\":\"2020-12-12 10:49:26\"" +
                                "}")
        ).andDo(print()).andExpect(status().isOk());
    }
}
