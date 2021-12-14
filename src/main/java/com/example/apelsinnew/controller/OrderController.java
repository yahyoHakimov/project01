package com.example.apelsinnew.controller;

import com.example.apelsinnew.entity.Customer;
import com.example.apelsinnew.entity.Product;
import com.example.apelsinnew.payload.*;
import com.example.apelsinnew.service.ApiResponseService;
import com.example.apelsinnew.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    ApiResponseService apiResponseService;

    @GetMapping("/invoice")
    public HttpEntity<?> getOrderInvoice() {
        ApiResponse apiResponse = orderService.getOrderInvoice();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/without-details")
    public HttpEntity<?> getOrderWithoutDetails() {
        ApiResponse apiResponse = orderService.getOrderWithoutDetail();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/details/{order_id}")
    public HttpEntity<?> getOrderDetailsById(@PathVariable Integer order_id){
        ApiResponse apiResponse = orderService.getOrderByDetailsId(order_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @PostMapping
    public ApiResponse createOrder(@RequestBody OrderDto orderDto,@RequestBody DetailDto detailDto) {
        ApiResponse apiResponse = orderService.getOrderCreatedInvoice(orderDto, detailDto);
        return apiResponse.isSuccess() ? apiResponseService.getSuccessResponse(apiResponse) : apiResponseService.failedResponse();
    }

    @GetMapping("customers_without_orders")
    public ApiResponse createOrder() {
        ApiResponse apiResponse = orderService.getCustomersWithoutOrders();
        return apiResponse.isSuccess() ? apiResponseService.getSuccessResponse(apiResponse) : apiResponseService.failedResponse();
    }
}
