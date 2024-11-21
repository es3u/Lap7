package com.example.lap7.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Teacher {

    @NotEmpty(message = "id can not be empty")
    @Size(min = 0 , max = 30)
    private String id;
    @NotEmpty(message = "name can not be empty")
    @Size(min = 4 , max= 30)
    private String name;

    @NotEmpty(message = "specialization can not be empty")
    @Size(min = 4 , max= 30)
    private String specialization ;
    @Email
    private String email ;
    @NotNull(message = "course can not be null")
    private ArrayList<String> courses;



    public void addCourse(String course) {
        this.courses.add(course);
    }


    public void removeCourse(String course) {
        this.courses.remove(course);
    }

}
