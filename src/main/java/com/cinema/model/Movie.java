package com.cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
public class Movie {
  @Id
  @Column(name = "Id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "Title")
  private String title;

  @Column(name = "Director")
  private String director;

  @Column(name = "Description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "DurationMin")
  private Integer durationMin;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getDurationMin() {
    return durationMin;
  }

  public void setDurationMin(Integer durationMin) {
    this.durationMin = durationMin;
  }
}
