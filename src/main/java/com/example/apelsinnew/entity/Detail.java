package com.example.apelsinnew.entity;

import com.example.apelsinnew.entity.template.TemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Detail extends TemplateEntity {
    private short quantity;

    @ManyToOne
    private Orders ord;
    @ManyToOne
    private Product product;

    public Detail(short quantity) {
        this.quantity = quantity;
    }
}
