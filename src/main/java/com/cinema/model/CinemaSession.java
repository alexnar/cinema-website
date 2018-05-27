package com.cinema.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CinemaSession")
public class CinemaSession {
  @Id
  @Column(name = "Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "StartTime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date startTime;

  @ManyToOne
  @JoinColumn(name = "MovieId")
  private Movie movie;

  @ManyToOne
  @JoinColumn(name = "HallId")
  private Hall hall;
}
