package com.example.springrestapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
}
