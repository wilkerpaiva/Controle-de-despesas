package com.controlededespesas.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;



@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name= "categoria")
@NoArgsConstructor
public class Category {

    private Long id;
    private String name;
    private Double amount;


}
