package com.crud.project.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
