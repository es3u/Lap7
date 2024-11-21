package com.example.lap7.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

//    Student
            @NotEmpty(message = "id can not be empty")
            @Size(min = 2 ,max = 10)
            private String id;
            @NotEmpty(message = "name van not be empty")
            @Size(min = 4 ,max = 20)
            private String name ;
//            @NotEmpty(message = "position can not be empty")
//            @Pattern(regexp = "^(student)" , message = "")
//            private String position;
            @NotEmpty(message ="user name van not be empty")
            @Size(min = 4 ,max = 15)
            private String userName;
            @NotEmpty(message = "password can not be empty ")
            @Size(min = 4 ,max = 20)
            @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",message = "\"Password must be between 8 and 20 characters and contain at least one uppercase letter, one lowercase letter, one number, and one special character (@$!%*?&).\"")
            private String password;
            @Email
            private String email;
            @NotEmpty(message = "age can not be null")
            @Size(min = 12 ,max = 90)
            private int age ;
            private boolean registered=false;
            @NotEmpty(message = "Course can be not empty")
            @Pattern(regexp = "^(course1|course2|course3|course4)$",message = "Choose Course 1, Course 2, Course 3, or Course 4")
            private String course ;


}
