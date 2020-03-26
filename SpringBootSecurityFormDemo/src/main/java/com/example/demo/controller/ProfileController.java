package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {

  @GetMapping(path = "index")
  public String admin(){
    return "profile/index";
  }
}
