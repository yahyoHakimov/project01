package com.example.apelsinnew.service;

import com.example.apelsinnew.entity.Customer;
import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.CustomerDto;
import com.example.apelsinnew.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    ApiResponseService apiResponseService;
    @Autowired
    CustomerRepository customerRepository;

    public ApiResponse getCustomerLastOrder() {
        try {
            List<Object> list = customerRepository.getCustomerNameIdDate();
            return apiResponseService.getResponse(list);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getOrderByCustomerCountry() {
        try {
            Object[] orderCustomer = customerRepository.getOrderCustomerByCountry();
            return apiResponseService.getResponse(orderCustomer);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getCustomerWithOutOrders() {
        try {
            Object[] customer = customerRepository.getCustomerWithOutOrders();
            return apiResponseService.getResponse(customer);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }
}
