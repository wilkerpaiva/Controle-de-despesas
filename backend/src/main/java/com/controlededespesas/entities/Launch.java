package com.controlededespesas.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_launch")
public class Launch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private LaunchType type;

    @Column(nullable = false, name = "amount")
    private Double amount;

    @Column(nullable = false, name = "date")
    private LocalDate date;

    public double entrada(double amount){
        return getAmount() + amount;
    }

    public double saida(double amount){
        return getAmount() - amount;
    }

}
