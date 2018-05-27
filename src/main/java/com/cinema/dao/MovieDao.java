package com.cinema.dao;

import com.cinema.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MovieDao {
  void add(Movie movie);
  List<Movie> all();
}
