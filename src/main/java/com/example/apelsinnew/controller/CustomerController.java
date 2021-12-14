package com.example.apelsinnew.controller;

import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.CustomerDto;
import com.example.apelsinnew.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers_without-orders")
    public HttpEntity<?> getCustomerWithoutOrders() {
        ApiResponse apiResponse = customerService.getCustomerWithOutOrders();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/last-order")
    public HttpEntity<?> getCustomerLastOrder() {
        ApiResponse customer = customerService.getCustomerLastOrder();
        return ResponseEntity.status(customer.isSuccess() ? 200 : 409).body(customer);
    }

    @GetMapping("/byCountry")
    public HttpEntity<?> getOrderByCustomerCountry() {
        ApiResponse apiResponse = customerService.getOrderByCustomerCountry();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);

    }
}
