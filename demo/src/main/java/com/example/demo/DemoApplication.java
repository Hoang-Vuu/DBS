package com.example.demo;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Order;
import com.example.demo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public DemoApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Customer customer = new Customer();

        customer.setFirstName("Hoang");
        customer.setLastName("Vu");
        customer.setEmail("hoang@test.com");
        customer.setPhone("123456789");

        Order order = new Order();
        order.setStatus("NEW");

        customer.addOrder(order);

        customerRepository.save(customer);

        System.out.println("Customer saved.");
        System.out.println("Orders saved automatically.");
    }
}