package com.cinema.service;

import com.cinema.model.Movie;

import java.util.List;

public interface MovieService {
  void add(Movie movie);
  void remove(Integer id);
  Movie get(Integer id);
  List<Movie> all();
}
