package com.cinema.controller;

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HelloController {

  private MovieService movieService;

  @Autowired
  public HelloController(MovieService movieService) {
    this.movieService = movieService;
  }

  @RequestMapping(value = "/")
  public String home(Model model) {
    List<Movie> all = movieService.all();
    return "hello";
  }

}
