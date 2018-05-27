package com.cinema.controller.api;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

  private MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  @ResponseStatus(value=HttpStatus.OK)
  public void add(@RequestBody Movie movie) {
    movieService.add(movie);
  }

  @RequestMapping(value = "/remove", method = RequestMethod.POST)
  @ResponseStatus(value=HttpStatus.OK)
  public void remove(@RequestParam("id") Integer id) {
    movieService.remove(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Movie get(@PathVariable("id") Integer id) {
    return movieService.get(id);
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public List<Movie> all() {
    return movieService.all();
  }

}
