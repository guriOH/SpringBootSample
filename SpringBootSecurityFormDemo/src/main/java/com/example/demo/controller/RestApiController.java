package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/public")
public class RestApiController {

  @GetMapping("test1")
  public String index(){
    return "test1";
  }

}
