package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.service.ExerciseService;

@Controller
@RequestMapping("/exercise")
public class ExerciseController {

  public static final String EXERCISE_VIEW = "exercise";
  public static final String mensaje = "exercise message";
  public static final Log LOG = LogFactory.getLog(ExerciseController.class);
  
  @Autowired
  @Qualifier("exerciseService")
  private ExerciseService exerciseService;
  
  
  @GetMapping("/method1")
  public RedirectView method1() {
    
    
    return new RedirectView("/exercise/method2");
  }
  
  @GetMapping("/method2")
  public ModelAndView method2() {
    long starttime = System.currentTimeMillis();
    exerciseService.log();
    ModelAndView mav = new ModelAndView(EXERCISE_VIEW);
    
    mav.addObject("mensaje", mensaje);
    
LOG.info("Tiempo de petición: " + (System.currentTimeMillis()- starttime)+ " ms");
    
    return mav;
  }
}
