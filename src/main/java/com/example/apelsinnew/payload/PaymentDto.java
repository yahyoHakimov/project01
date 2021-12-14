package com.example.apelsinnew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Integer id;
    private Timestamp time;
    private Integer amount;
    private Integer invoice_id;
    private Integer order_id;
    private Integer detail_id;
    private Integer product_id;

    public PaymentDto(Timestamp time, Integer amount, Integer invoice_id) {
        this.time = time;
        this.amount = amount;
        this.invoice_id = invoice_id;
    }

    public PaymentDto(Integer id, Timestamp time, Integer amount) {
        this.id = id;
        this.time = time;
        this.amount = amount;
    }
}
