package com.controlededespesas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "tb_launch")
public class Launch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private LaunchType type;

    @Column(name = "name")
    private String name;

    @Column(nullable = false, name = "amount")
    private Double amount;

    @Column(name = "date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonFormat(pattern = "dd/MM/yy")
    private LocalDateTime date;

    public Launch() {
        super();
        this.setDate(LocalDateTime.now());
    }

    public Launch(Long id, Integer type, String name,
                  Double amount) {
        this.id = id;
        this.type = LaunchType.toEnum(type);
        this.name = name;
        this.amount = amount;
        this.setDate(LocalDateTime.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Launch launch = (Launch) o;
        return id != null && Objects.equals(id, launch.id);

    }
}
