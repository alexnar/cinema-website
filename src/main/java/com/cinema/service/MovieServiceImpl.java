package com.cinema.service;

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

  private MovieDao movieDao;

  @Autowired
  public MovieServiceImpl(MovieDao movieDao) {
    this.movieDao = movieDao;
  }

  @Override
  public void add(Movie movie) {
    movieDao.add(movie);
  }

  @Override
  public void remove(Integer id) {
    movieDao.remove(id);
  }

  @Override
  public Movie get(Integer id) {
    return movieDao.get(id);
  }

  @Override
  public List<Movie> all() {
    return movieDao.all();
  }


}
