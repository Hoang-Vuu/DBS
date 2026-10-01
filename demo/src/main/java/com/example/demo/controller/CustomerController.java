package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public Customer createCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Hoang");
        customer.setLastName("Vu");
        customer.setEmail("hoang@test.com");
        customer.setPhone("123456789");

        Order order1 = new Order();
        order1.setStatus("NEW");

        Order order2 = new Order();
        order2.setStatus("DELIVERED");

        customer.addOrder(order1);
        customer.addOrder(order2);

        return customerRepository.save(customer);
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
        return "Customer deleted successfully";
    }
}