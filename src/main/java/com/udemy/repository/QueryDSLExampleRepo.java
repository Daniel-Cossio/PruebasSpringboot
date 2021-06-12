package com.udemy.repository;

import org.springframework.stereotype.Repository;

import com.udemy.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
  private QCourse qCourse = QCourse.course;
  
}
