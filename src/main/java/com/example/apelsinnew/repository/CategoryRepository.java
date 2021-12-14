package com.example.apelsinnew.repository;

import com.example.apelsinnew.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(nativeQuery = true, value = "select p.id, description, p.name, photo, price, category_id from product p inner join category c on c.id = p.category_id  where p.id =:product_id")
    List<Category> getCategoryByProductId(Integer product_id);
}
