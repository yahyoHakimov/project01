package com.example.apelsinnew.entity;

import com.example.apelsinnew.entity.template.TemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends TemplateEntity {
    @Column(precision = 8, scale = 2)
    private Integer amount;
    private Date issued;
    private Date due;
    @ManyToOne
    private Orders order;

    public Invoice(Integer amount, Date issued, Orders order) {
        this.amount = amount;
        this.issued = issued;
        this.order = order;
    }
}
