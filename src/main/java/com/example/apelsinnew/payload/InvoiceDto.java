package com.example.apelsinnew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private Integer id;
    private Integer amount;
    private Date issued;
    private Date dueDate;
    private Integer order_id;

    public InvoiceDto(Integer amount, Date issued, Date dueDate, Integer order_id) {
        this.amount = amount;
        this.issued = issued;
        this.dueDate = dueDate;
        this.order_id = order_id;
    }

}
