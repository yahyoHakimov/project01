package com.example.apelsinnew.repository;

import com.example.apelsinnew.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query(nativeQuery = true, value = "select o.id, o.date, i.amount from orders o inner join invoice i on o.id = i.order_id")
    Object[] getOrderInvoice();

    @Query(nativeQuery = true, value = "select o.id, o.date, o.customer_id from orders o where date < to_date('06/09/2016', 'DD/MM/YYYY')")
    Object[] getOrderWithoutDetails();

    @Query(nativeQuery = true, value = "select o.id, o.date, o.customer_id, p.name from orders o " +
            "inner join detail d on o.id = d.ord_id " +
            "inner join product p on p.id = d.product_id where d.id =:order_id")
    List<Orders> getOrderByDetailsId(Integer order_id);



}
