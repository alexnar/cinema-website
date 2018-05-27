package com.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "Hall")
public class Hall {
  @Id
  @Column(name = "Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;
}
