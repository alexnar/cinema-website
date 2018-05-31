package com.cinema.service;

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;
import com.cinema.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

  private static final Logger logger = Logger.getLogger(MovieServiceImpl.class);


  private MovieDao movieDao;

  @Autowired
  public MovieServiceImpl(MovieDao movieDao) {
    this.movieDao = movieDao;
  }

  @Override
  public void add(Movie movie) {
    verify(movie);
    movieDao.add(movie);
  }

  @Override
  public void update(Movie movie, Integer id) {
    movieDao.update(movie, id);
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

  private void verify(Movie movie) {
    if (movie == null) {
      ServiceException exception = new ServiceException("Movie entity is null");
      logger.error(exception.getMessage(), exception);
      throw exception;
    }
  }

}
