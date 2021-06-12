package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
  
  public static final String EXAMPLE404_VIEW = "example4";
  
  @GetMapping("/404")
  public ModelAndView showView() {
    ModelAndView mav = new ModelAndView(EXAMPLE404_VIEW);
    
    return mav;
  }
  

}
