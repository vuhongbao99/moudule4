package com.example.bai_tap_blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_category")
    private Integer idCategory;
    @Column(name="name_category")
    private String nameCategory;

}
