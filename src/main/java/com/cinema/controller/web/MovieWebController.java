package com.cinema.controller.web;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieWebController {

  private final MovieService movieService;

  @Autowired
  public MovieWebController(MovieService movieService) {
    this.movieService = movieService;
  }

  @RequestMapping(value = "/")
  public String movies(Model model) {
    List<Movie> movies = movieService.all();
    model.addAttribute("movies", movies);
    return "movies";
  }

  @RequestMapping(value = "/admin")
  public String admin() {
    return "movies_admin";
  }

}
