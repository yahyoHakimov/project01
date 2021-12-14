package com.example.apelsinnew.entity;

import com.example.apelsinnew.entity.template.TemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends TemplateEntity {

    @Column(length = 14)
    private String name;
    @Column(length = 3)
    private String country;
    private String address;
    @Column(length = 50)
    private String phone;

}
