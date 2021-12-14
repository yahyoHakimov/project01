package com.example.apelsinnew.entity;

import com.example.apelsinnew.entity.template.TemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders extends TemplateEntity {
    private Date date;
    @ManyToOne
    private Customer customer;
}
