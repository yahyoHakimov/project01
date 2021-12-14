package com.example.apelsinnew.entity;

import com.example.apelsinnew.entity.template.TemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends TemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String name;
    @Column(length = 20)
    private String description;
    @Column(precision = 6, scale = 2)
    private Integer price;
    @Column(length = 1024)
    private String photo;

    @ManyToOne
    private Category category;

    public Product(Integer id) {
        this.id = id;
    }

    public Product(String name, String description, Integer price, String photo, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.category = category;
    }
}
