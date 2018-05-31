package com.cinema.controller.api;

import com.cinema.model.Movie;
import com.cinema.service.MovieService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

  private MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @PostMapping("/")
  @ResponseStatus(value=HttpStatus.OK)
  public void add(@RequestBody Movie movie) {
    movieService.add(movie);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value=HttpStatus.OK)
  public void remove(@PathVariable Integer id) {
    movieService.remove(id);
  }

  @GetMapping("/{id}")
  public Movie get(@PathVariable Integer id) {
    return movieService.get(id);
  }

  @GetMapping("/all")
  public List<Movie> all() {
    return movieService.all();
  }

  @PutMapping("/{id}")
  public void update(@RequestBody Movie movie, @PathVariable Integer id) {

  }

}
