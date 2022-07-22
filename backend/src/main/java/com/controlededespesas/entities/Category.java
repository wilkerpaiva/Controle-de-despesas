package com.controlededespesas.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Double amount;


}
