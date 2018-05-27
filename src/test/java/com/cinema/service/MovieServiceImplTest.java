package com.cinema.service;

import com.cinema.dao.MovieDao;
import com.cinema.service.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MovieServiceImpl.class, TestConfiguration.class})
public class MovieServiceImplTest {

  @Autowired
  private MovieDao movieDao;

  @Autowired
  MovieService movieService;

  @Test(expected = ServiceException.class)
  public void addNullDoesNotCallDao() {
    movieService.add(null);
    verify(movieDao, never()).add(any());
  }
  }