package com.example.apelsinnew.controller;

import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.InvoiceDto;
import com.example.apelsinnew.service.ApiResponseService;
import com.example.apelsinnew.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    ApiResponseService apiResponseService;

    @GetMapping("/expired-invoice")
    public HttpEntity<?> getExpiredInvoice() {
        ApiResponse apiResponse = invoiceService.getExpiredInvoice();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/wrong-date-invoice")
    public HttpEntity<?> getWrongInvoice() {
        ApiResponse apiResponse = invoiceService.getWrongDateInvoice();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }
}
