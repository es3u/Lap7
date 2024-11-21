package com.example.lap7.Service;

import com.example.lap7.Model.Course;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Service
public class CourseService {

    ArrayList<Course> courses = new ArrayList<>();

  public ArrayList<Course> getCourses() {
      return courses;
  }
  public void addCourses(Course courses) {
      this.courses.add(courses);

  }

  public boolean updateCourse(String id ,Course course) {
      for (Course c : courses) {
          if (c.getIdCourse().equals(id)) {
             int index = courses.indexOf(c);
              courses.set(index,course);
          }else
              return false;
      }
      return true;
  }

  public boolean deleteCourse(String id) {
      for (Course c : courses) {
          if (c.getIdCourse().equals(id)) {
              courses.remove(c);
          }else
              return false;
      }
      return true;
  }

  public Course getCourse(String id) {
      for (Course c : courses) {
          if (c.getIdCourse().equals(id)) {
              return c;
          }
      }
      return null;
  }

 public ArrayList<Course> ShowEnded(){
      ArrayList<Course> course = new ArrayList<>();
      for (Course c : courses) {
          if (c.getEndDate().isBefore(LocalDate.now())) {
              course.add(c);
          }
      }
      return course;
 }

 public Course ShowCourse(String nameCourse) {
      for (Course c : courses) {
          if (c.getNameOfCourse().equals(nameCourse)) {
              return c;
          }
      }
      return null;
 }

 public boolean sameDate() {

      for(int i= 0 ; i < courses.size() ; i++) {
          for (int j = 0 ; j < courses.size(); j++) {
              if (courses.get(i).getStartDate().isEqual(courses.get(j).getStartDate())) {
                  courses.get(j).setStartDate(courses.get(i).getEndDate());
                  return true;
              }
          }
      }
      return false;
 }

}
