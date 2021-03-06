package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.model.Person;
import com.udemy.service.ExampleService;


@Controller 
@RequestMapping("/say")
public class HelloWorldController {
  
  public static final String HELLOWORLD_VIEW = "helloWorld";
  
  
  @Autowired
  @Qualifier("exampleService")
  private ExampleService exampleService;
  
  
  
  @Autowired
  @Qualifier("exampleComponent")
  private ExampleComponent exampleComponent;

  //Forma 1 de retornar templates
  @GetMapping("/exampleString")
  public String helloWorld(Model model) {
    exampleComponent.sayHello();
    model.addAttribute("people", exampleService.getListPeople());
    return HELLOWORLD_VIEW;
  }
  
  //Forma 2 de retornar templates
  @GetMapping("/exampleMAV")
  public ModelAndView helloWorldMAV() {
    ModelAndView mav = new ModelAndView(HELLOWORLD_VIEW);
    mav.addObject("people", exampleService.getListPeople());
    
    return mav;
  }
  
  
  
  
  
  
  
  
  
  
  
}
