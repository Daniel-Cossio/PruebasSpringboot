package com.udemy.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.service.ExerciseService;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService{

  @Override
  public void log() {
    
    final Log LOGGER = LogFactory.getLog(ExerciseServiceImpl.class);
    LOGGER.info("HELLO FROM EXCERCISESERVICEIMPL");
  }
  

}
