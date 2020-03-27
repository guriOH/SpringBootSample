package com.example.jwt_demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/public")
@CrossOrigin
public class PublicRestApiController {

  @GetMapping(path = "test")
  public String test(){
    return "test";
  }
  @GetMapping(path = "test2")
  public String test2(){
    return "test2";
  }
  @GetMapping(path = "test3")
  public String test3(){
    return "test3";
  }
}
