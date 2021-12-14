package com.example.apelsinnew.repository;

import com.example.apelsinnew.entity.Category;
import com.example.apelsinnew.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Query(nativeQuery = true, value = "select * from invoice i where i.due > i.issued")
    Object[] getExpiredInvoice();

    @Query(nativeQuery = true, value = "select i.id, i.issued,o.id, o.date from invoice i inner join orders o on o.id = i.order_id where i.issued < o.date")
    Object[] getWrongInvoiceDate();
    
    @Query(nativeQuery = true, value = "select i.id from customer c \n" +
            "    inner join orders o on c.id = o.customer_id \n" +
            "    inner join invoice i on o.id = i.order_id where o.date > to_date('01/01/2016', 'DD/MM/YYYY')  and o.date < to_date('31/12/2016','DD/MM/YYYY')")
    Object[] getCreatedInvoice();
}
