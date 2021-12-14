package com.example.apelsinnew.service;

import com.example.apelsinnew.entity.*;
import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.PaymentDto;
import com.example.apelsinnew.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    ApiResponseService apiResponseService;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DetailRepository detailRepository;


    public ApiResponse addPayment(PaymentDto paymentDto) {
        try {
            Timestamp time = Timestamp.from(Instant.now());

            Payment payment = null;

            List<Product> product = paymentRepository.getPaymentByInvoiceIdForAmount(paymentDto.getInvoice_id());
            List<Detail> details = paymentRepository.getPaymentByInvoiceIdForDetails(paymentDto.getInvoice_id());

            for (int i = 0; i < product.size(); i++) {
                Integer price = product.get(i).getPrice();
                for (int j = 0; j < details.size(); j++) {
                    short quantity = details.get(j).getQuantity();
                    Short sh = new Short(quantity);
                    // returns int value of Short
                    int q = Short.toUnsignedInt(sh);
                    Integer amount = (product.get(i).getPrice()) * q;
                    new Payment(
                            time,
                            amount,
                            paymentDto.getInvoice_id() != 0 ? invoiceRepository.findById(paymentDto.getInvoice_id()).orElseThrow(() -> new ResourceNotFoundException("getInvoice")) : null
                            );
                    if (details.get(i).getId() == details.size())
                        break;
                }
            }
            Payment save = paymentRepository.save(payment);
            return apiResponseService.getSuccessResponse(save);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getPaymentDetails(Integer payment_id) {
        try {
            Object[] paymentDetails = paymentRepository.getPaymentDetails(payment_id);
            return apiResponseService.getResponse(paymentDetails);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

}
