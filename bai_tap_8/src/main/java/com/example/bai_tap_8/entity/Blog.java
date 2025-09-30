package com.example.bai_tap_8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer id;

    @Column(name = "blog_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate day;

    @Column(name = "blog_description")
    private String blog_description;

    @Column(name = "blog_context",nullable = false)
    private String context;


}
