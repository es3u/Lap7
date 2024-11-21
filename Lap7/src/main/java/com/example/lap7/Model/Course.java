package com.example.lap7.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Course {
    @NotEmpty(message = "is dor course can not be empty")
    @Size(min = 0, max = 20)
    private String idCourse;
    @NotEmpty(message = "name of course can not be empty")
    @Size(min = 4 ,max = 20)
    private String nameOfCourse;
    @NotEmpty(message = "description can not be empty")
    @Size(min = 4 ,max = 100)
    private String description;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate endDate;

}
