package com.example.quan_ly_h.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Big {
    @Id
    private String idBig;
    private LocalDate dateOfEntry;
    private double entryWeight;
    private LocalDate dateOfExit;
    private double exitWeight;
    @Column(nullable = false, columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDelete = false;

    @ManyToOne
    @JoinColumn
    private CountryOrigin countryOrigin;

}
