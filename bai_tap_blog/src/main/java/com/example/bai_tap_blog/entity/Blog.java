package com.example.bai_tap_blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "blogs")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog extends Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category category;

}
