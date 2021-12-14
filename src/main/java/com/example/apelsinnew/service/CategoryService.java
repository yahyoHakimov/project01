package com.example.apelsinnew.service;

import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.payload.CategoryDto;
import com.example.apelsinnew.entity.Category;
import com.example.apelsinnew.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ApiResponseService apiResponseService;

    public ApiResponse getCategoryList() {
        try {
            List<Category> all = categoryRepository.findAll();
            return apiResponseService.getResponse(all);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }

    public ApiResponse getCategoryByProductId(Integer product_id) {
        try {
                List<Category> categories = categoryRepository.getCategoryByProductId(product_id);
                return apiResponseService.getResponse(categories);
        } catch (Exception e) {
            return apiResponseService.tryErrorResponse();
        }
    }
}
