package com.example.apelsinnew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private Timestamp date;
    private Integer customer_id;

    private Integer product_id;
    private Integer order_id;
    private short quantity;

    public OrderDto(Timestamp date, Integer customer_id) {
        this.date = date;
        this.customer_id = customer_id;
    }

    public OrderDto(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public OrderDto(Integer product_id, short quantity) {
        this.product_id = product_id;
        this.quantity = quantity;
    }
}
