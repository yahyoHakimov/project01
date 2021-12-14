package com.example.apelsinnew.service;

import com.example.apelsinnew.entity.Product;
import com.example.apelsinnew.payload.*;
import com.example.apelsinnew.repository.CategoryRepository;
import com.example.apelsinnew.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ApiResponseService apiResponseService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse getProductBestSeller() {
        try {
            Object[] bookSeller = productRepository.getBookSeller();
            return apiResponseService.getResponse(bookSeller);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getProductList() {
        try {
            List<Product> all = productRepository.findAll();
            return apiResponseService.getResponse(all);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getProductDetailsById(Integer product_id) {
        try {
            List<Product> productList = productRepository.getProductByDetailId(product_id);
            return apiResponseService.getResponse(productList);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getBulkProduct() {
        try {
            Object[] bulkProduct = productRepository.getBulkProduct();
            return apiResponseService.getResponse(bulkProduct);
        }catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

}
