package com.cinema.dao;

import com.cinema.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovieDao {
  void add(Movie movie);
  void update(Movie movie, Integer id);
  void remove(Integer id);
  Movie get(Integer id);
  List<Movie> all();
}
