package com.cinema.controller;

import com.cinema.dao.MovieDao;
import com.cinema.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HelloController {

  @Autowired
  private MovieDao movieDao;

  @RequestMapping(value = "/")
  public String home(Model model) {
    List<Movie> all = movieDao.all();
    return "hello";
  }

}
