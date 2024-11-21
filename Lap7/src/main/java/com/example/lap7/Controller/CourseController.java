package com.example.lap7.Controller;

import com.example.lap7.Model.Course;
import com.example.lap7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    @GetMapping("/getCourses")
    public ResponseEntity getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @PostMapping("/addCourses")
    public ResponseEntity addCourses(@RequestBody@Valid Course course , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        courseService.addCourses(course);
        return ResponseEntity.ok().body("Added course");
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity updateCourse(@PathVariable String id, @RequestBody@Valid Course course , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        boolean result = courseService.updateCourse(id, course);
        if (result) {
            return ResponseEntity.ok().body("Update course");
        }
        return ResponseEntity.badRequest().body("Update failed");
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id) {
       boolean deleted = courseService.deleteCourse(id);
       if (deleted) {
           return ResponseEntity.ok().body("Deleted course");
       }
       return ResponseEntity.badRequest().body("not found id");
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity getCourse(@PathVariable String id) {
        if (courseService.getCourse(id) != null) {
            return ResponseEntity.ok().body(courseService.getCourse(id));
        }
        return ResponseEntity.badRequest().body("not found id");
    }

    @GetMapping("/ShowEnded")
    public ResponseEntity ShowEnded() {
        return ResponseEntity.ok().body(courseService.ShowEnded());
    }

    @GetMapping("/ShowCourse/{nameCourse}")
    public ResponseEntity ShowCourse(@PathVariable String nameCourse) {
        if (courseService.getCourse(nameCourse) != null) {
            return ResponseEntity.ok().body(courseService.getCourse(nameCourse));
        }
        return ResponseEntity.badRequest().body("not found course");
    }


    @PutMapping("/sameDate")
    public ResponseEntity sameDate() {
        boolean sameDate = courseService.sameDate();
       if (sameDate) {
           return ResponseEntity.ok().body("updeted course date");

       }
       return ResponseEntity.badRequest().body("Everything is ok");
    }



}
