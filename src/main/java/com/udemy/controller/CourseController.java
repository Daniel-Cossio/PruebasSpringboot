package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

  public static final String VIEW = "courses";
  private static final Log LOG = LogFactory.getLog(CourseController.class);
  private CourseConverter converter;
  
  @Autowired
  @Qualifier("courseServiceImpl")
  private  CourseService courseService;
  
  @GetMapping("/listcourses")
  public ModelAndView listAllCourses() {
    LOG.info("CALL: listAllCourses()");
    ModelAndView mav = new ModelAndView(VIEW);
    mav.addObject("course", new Course());
    mav.addObject("courses", courseService.listAllCourses());
    return mav;
  }
  
  @PostMapping("/addcourse")
  public String addCourse(@ModelAttribute(name="course") Course course) {

    LOG.info("CALL: addCourses() "  + "-- PARAMS: " + course.toString());
    ModelAndView mav = new ModelAndView(VIEW);
    mav.addObject("course", courseService.addCourse(course));
    return "redirect:/courses/listcourses";
  }
  
  
  
}
