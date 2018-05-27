package com.cinema.service;

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfiguration {
  @Bean
  public MovieDao movieDao() {
    return Mockito.mock(MovieDao.class);
  }
}
