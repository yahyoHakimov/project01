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
public class Category extends TemplateEntity {
    @Column(length = 250)
    private String name;
}
