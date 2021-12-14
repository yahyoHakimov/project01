package com.example.apelsinnew.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Integer id;
    private String name;
    private String country;
    private String address;
    private String phone;

    public CustomerDto(String name, String country, String address, String phone) {
        this.name = name;
        this.country = country;
        this.address = address;
        this.phone = phone;
    }
}
