package com.example.apelsinnew.controller;

import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.CategoryDto;
import com.example.apelsinnew.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerTypePredicate;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public HttpEntity<?> getCategoryList() {
        ApiResponse apiResponse = categoryService.getCategoryList();
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/{product_id}")
    public HttpEntity<?> getCategoryById(@PathVariable Integer product_id) {
        ApiResponse apiResponse = categoryService.getCategoryByProductId(product_id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

}
