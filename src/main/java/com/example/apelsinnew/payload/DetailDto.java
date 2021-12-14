package com.example.apelsinnew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDto {
    private Integer id;
    private short quantity;
    private Integer order_id;
    private Integer product_id;

    public DetailDto(short quantity, Integer order_id, Integer product_id) {
        this.quantity = quantity;
        this.order_id = order_id;
        this.product_id = product_id;
    }
}
