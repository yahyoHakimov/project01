package com.example.apelsinnew.service;

import com.example.apelsinnew.entity.Customer;
import com.example.apelsinnew.entity.Detail;
import com.example.apelsinnew.entity.Invoice;
import com.example.apelsinnew.entity.Orders;
import com.example.apelsinnew.payload.*;
import com.example.apelsinnew.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    ApiResponseService apiResponseService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    DetailRepository detailRepository;
    @Autowired
    InvoiceRepository invoiceRepository;

    public ApiResponse getOrderInvoice() {
        try {
            Object[] orderInvoice = orderRepository.getOrderInvoice();
            return apiResponseService.getResponse(orderInvoice);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getOrderWithoutDetail() {
        try {
            Object[] orderWithoutDetails = orderRepository.getOrderWithoutDetails();
            return apiResponseService.getResponse(orderWithoutDetails);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getOrderByDetailsId(Integer order_id) {
        try {
            List<Orders> orderByDetailsId = orderRepository.getOrderByDetailsId(order_id);
            return apiResponseService.getResponse(orderByDetailsId);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getOrderCreatedInvoice(OrderDto orderDto, DetailDto detailDto) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String stringDate = formatter.format(date);
            Date date1 = new SimpleDateFormat().parse(stringDate);
            Orders order = new Orders(
                    date1,
                    orderDto.getCustomer_id() != null ? customerRepository.findById(orderDto.getCustomer_id())
                            .orElseThrow(() -> new ResourceNotFoundException("get Customer")) : null
            );
            Orders orders = orderRepository.save(order);
            Integer orderId = orders.getId();
            Detail detail = new Detail(
                    detailDto.getQuantity(),
                    detailDto.getOrder_id() != null ? orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("NotOrder_id")) : null,
                    detailDto.getProduct_id() != null ? productRepository.findById(detailDto.getProduct_id()).orElseThrow(() -> new ResourceNotFoundException("NotProduct_id")) : null
            );
            Detail detail1 = detailRepository.save(detail);
            short quantity = detail.getQuantity();
            Short y = new Short(quantity);
            // returns int value of Short
            int q = Short.toUnsignedInt(y);
            Integer amount = (detail.getProduct().getPrice()) * q;
            Date date2 = new Date();
            Invoice invoice = new Invoice(
                    amount,
                    date2,
                    orderId != null ? orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("getOrder")) : null
            );
            return apiResponseService.getResponse(invoice);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getCustomersWithoutOrders() {
        try {
            List<Date> dates = new ArrayList<Date>();

            String str_date = "01/01/2016";
            String end_date = "31/12/2016";

            DateFormat formatter;

            formatter = new SimpleDateFormat("MM/yyyy");
            Date startDate = (Date) formatter.parse(str_date);
            Date endDate = (Date) formatter.parse(end_date);
            long interval = 24 * 1000 * 60; // 1 hour in millis
            long endTime = endDate.getTime(); // create your endtime here, possibly using Calendar or Date
            long curTime = startDate.getTime();

            List<Orders> orders = orderRepository.findAll();
            List<Customer> customers = customerRepository.findAll();
            Object[] createdInvoice = new Object[0];


//            for (int j = 0; j < customers.size(); j++) {
//                boolean a = false;
//                for (int i = 0; i < orders.size(); i++) {
//                    while (curTime <= endTime) {
//                        dates.add(new Date(curTime));
//                        curTime += interval;
//                    }
//                    for (int g = 0; g < dates.size(); i++) {
//                        Date lDate = (Date) dates.get(g);
//                        if ((customers.get(j).getId() == (orders.get(i).getCustomer().getId()))) {
//                            a = true;
//                            break;
//                        }
//                    }
//                }
//                if (!a) {
//                    createdInvoice = invoiceRepository.getCreatedInvoice();
//                }
//            }
            return apiResponseService.getResponse(createdInvoice);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

}
