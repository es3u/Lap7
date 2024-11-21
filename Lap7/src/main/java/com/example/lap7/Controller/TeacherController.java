package com.example.lap7.Controller;

import com.example.lap7.Model.Teacher;
import com.example.lap7.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/getAllTeachers")
    public ResponseEntity getAllTeachers() {
        return  ResponseEntity.ok().body(teacherService.getAllTeachers());
    }

    @PostMapping("/addTeacher")
    public ResponseEntity addTeacher(@RequestBody@Valid Teacher teacher , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        teacherService.addTeacher(teacher);
        return  ResponseEntity.status(200).body("Teacher added successfully");
    }

    @PutMapping("/updateTeacher")
    public ResponseEntity updateTeacher(@PathVariable String id, @RequestBody @Valid Teacher teacher , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        boolean updated = teacherService.updateTeacher(id, teacher);
        if (updated) {
            return  ResponseEntity.status(200).body("Teacher updated successfully");
        } else {
            return  ResponseEntity.status(200).body("Teacher not found");
        }
    }

@DeleteMapping("/deleteTeacher")
    public ResponseEntity deleteTeacher(@PathVariable String id) {
        boolean deleted = teacherService.deleteTeacher(id);
        if (deleted) {
            return  ResponseEntity.status(200).body("Teacher deleted successfully");
        } else {
            return  ResponseEntity.status(200).body("Teacher not found");
        }
    }

    @PostMapping("/addCourseToTeacher/{id}/{course}")
    public ResponseEntity addCourseToTeacher(@PathVariable @Valid String id, @PathVariable @Valid String course , Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }

        boolean added = teacherService.addCourseToTeacher(id, course);
        if (added) {
            return  ResponseEntity.status(200).body("Course added successfully");
        } else {
            return  ResponseEntity.status(200).body("Teacher not found");
        }
    }
@DeleteMapping("/removeCourseFromTeacher/{id}/{course}")
    public ResponseEntity removeCourseFromTeacher(@PathVariable String id, @PathVariable String course ) {

        boolean removed = teacherService.removeCourseFromTeacher(id, course);
        if (removed) {
            return  ResponseEntity.status(200).body("Course removed successfully");
        } else {
            return  ResponseEntity.status(200).body("Teacher or course not found");
        }
    }





}
