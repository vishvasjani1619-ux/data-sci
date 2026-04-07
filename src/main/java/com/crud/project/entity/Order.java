package com.crud.project.entity;

import jakarta.persistence.*;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderName;

    @ManyToOne
    @JoinColumn(name = "users")
    private User user;

}
