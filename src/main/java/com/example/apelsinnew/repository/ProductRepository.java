package com.example.apelsinnew.repository;

import com.example.apelsinnew.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(nativeQuery = true, value = "select p.id as id, p.name as name, count(d.product_id) as total from detail d inner join product p on p.id = d.product_id group by p.id ")
    Object[] getBookSeller();

    @Query(nativeQuery = true, value = "select d.quantity from product p inner join detail d on p.id = d.product_id where quantity > 8")
    Object[] getBulkProduct();

    @Query(nativeQuery = true, value = "select p.id,p.description,p.name,p.photo,p.price, p.category_id from detail d inner join product p on p.id = d.product_id where p.id =:product_id")
    List<Product> getProductByDetailId(Integer product_id);
}
