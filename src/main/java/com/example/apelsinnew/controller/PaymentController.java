package com.example.apelsinnew.controller;

import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.PaymentDto;
import com.example.apelsinnew.service.ApiResponseService;
import com.example.apelsinnew.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    ApiResponseService apiResponseService;
    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ApiResponse addPayment(@RequestBody PaymentDto paymentDto) {
        ApiResponse apiResponse = paymentService.addPayment(paymentDto);
        return apiResponse.isSuccess() ? apiResponseService.getSuccessResponse(apiResponse) : apiResponseService.failedResponse();
    }

    @GetMapping("/details/{payment_id}")
    public HttpEntity<?> getPayment(@PathVariable Integer payment_id) {
        ApiResponse apiResponse = paymentService.getPaymentDetails(payment_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
