package com.example.apelsinnew.service;

import com.example.apelsinnew.entity.Invoice;
import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.InvoiceDto;
import com.example.apelsinnew.repository.InvoiceRepository;
import com.example.apelsinnew.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ApiResponseService apiResponseService;

    public ApiResponse getExpiredInvoice() {
        try {
            Object[] expiredInvoice = invoiceRepository.getExpiredInvoice();
            return apiResponseService.getResponse(expiredInvoice);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getWrongDateInvoice() {
        try {
            Object[] wrongInvoiceDate = invoiceRepository.getWrongInvoiceDate();
            return apiResponseService.getResponse(wrongInvoiceDate);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

}
