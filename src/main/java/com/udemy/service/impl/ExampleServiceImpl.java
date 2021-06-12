package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
  
  private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
  
  @Override
  public List<Person> getListPeople() {
      List<Person> people = new ArrayList<>();
      people.add(new Person("Felipe", 21));
      people.add(new Person("Daniel", 22));
      people.add(new Person("Isabella", 20));
      people.add(new Person("Sonia", 34));
      LOG.info("HELLO FROM SERVICE");
      return people;
    
  }

}
