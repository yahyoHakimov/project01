package com.example.apelsinnew.repository;

import com.example.apelsinnew.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true, value = "select c.id, c.name, o.date from customer c inner join orders o on c.id = o.customer_id order by o.date desc limit 1")
    List<Object> getCustomerNameIdDate();

    @Query(nativeQuery = true, value = "select * from customer")
    Object[] getOrderCustomer();

    @Query(nativeQuery = true, value = "select c.country from customer c inner join orders o on c.id = o.customer_id where o.date > to_date('01/01/2016', 'DD/MM/YYYY') and o.date < to_date('31/12/2016','DD/MM/YYYY') group by c.country")
    Object[] getOrderCustomerByCountry();


    @Query(nativeQuery = true, value = "select * from customer c inner join orders o on c.id = o.customer_id where date between to_date('01-01-2016','dd-mm-yyyy') and to_date('01-12-2016','dd-mm-yyyy')")
    Object[] getCustomerWithOutOrders();
}
