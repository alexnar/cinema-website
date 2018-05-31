package com.cinema.controller.web;

import com.cinema.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeWebController {
  @RequestMapping(value = "/")
  public String home() {
    return "home";
  }
}
