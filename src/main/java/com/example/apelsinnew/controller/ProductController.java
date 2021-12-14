package com.example.apelsinnew.controller;

import com.example.apelsinnew.entity.Product;
import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.ProductDto;
import com.example.apelsinnew.repository.CategoryRepository;
import com.example.apelsinnew.repository.ProductRepository;
import com.example.apelsinnew.service.ApiResponseService;
import com.example.apelsinnew.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ApiResponseService apiResponseService;

    @GetMapping
    public HttpEntity<?> getBestSellProduct() {
        ApiResponse apiResponse = productService.getProductBestSeller();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/list")
    public HttpEntity<?> getProductList() {
        ApiResponse apiResponse = productService.getProductList();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/details/{product_id}")
    public HttpEntity<?> getProductDetailsById(@PathVariable Integer product_id) {
        ApiResponse apiResponse = productService.getProductDetailsById(product_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/bulk")
    public HttpEntity<?> getBulkProduct() {
        ApiResponse apiResponse = productService.getBulkProduct();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }


}
