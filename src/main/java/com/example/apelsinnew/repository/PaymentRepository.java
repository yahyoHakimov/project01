package com.example.apelsinnew.repository;

import com.example.apelsinnew.entity.Category;
import com.example.apelsinnew.entity.Detail;
import com.example.apelsinnew.entity.Payment;
import com.example.apelsinnew.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {

    @Query(nativeQuery = true, value = "select p.id,p.amount,p.time,p.invoice_id_id from payment p where id =:payment_id")
    Object[] getPaymentDetails(Integer payment_id);

    @Query(nativeQuery = true, value = "select * from product\n" +
            "    inner join detail d on product.id = d.product_id\n" +
            "    inner join orders o on o.id = d.ord_id\n" +
            "    inner join invoice i on o.id = i.order_id\n" +
            "    inner join payment p on i.id = p.invoice_id where p.invoice_id = i.id and i.order_id = o.id and o.id = d.ord_id and d.product_id = p.id and p.id =:invoice_id")
    List<Product> getPaymentByInvoiceIdForAmount(Integer invoice_id);

    @Query(nativeQuery = true, value = "select d.quantity from product\n" +
            "    inner join detail d on product.id = d.product_id\n" +
            "    inner join orders o on o.id = d.ord_id\n" +
            "    inner join invoice i on o.id = i.order_id\n" +
            "    inner join payment p on i.id = p.invoice_id where (p.invoice_id = i.id) and (i.order_id = o.id) and (o.id = d.ord_id) and (d.product_id = p.id) and p.id =:invoice_id")
    List<Detail> getPaymentByInvoiceIdForDetails(Integer invoice_id);

    @Query(nativeQuery = true, value = "select product.price from product\n" +
            "    inner join detail d on product.id = d.product_id\n" +
            "    inner join orders o on o.id = d.ord_id\n" +
            "    inner join invoice i on o.id = i.order_id\n" +
            "    inner join payment p on i.id = p.invoice_id_id where p.invoice_id_id = i.id and i.order_id = o.id and o.id = d.ord_id and d.product_id = p.id and p.id =: product_id")
    List getPaymentAmountByInvoiceId(Integer product_id);
}
