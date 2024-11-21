package com.example.lap7.Service;

import com.example.lap7.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    private ArrayList<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }


    public ArrayList<Teacher> getAllTeachers() {
        return teachers;
    }


    public boolean updateTeacher(String id, Teacher Teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId().equals(id)) {
                teachers.set(i, Teacher);
                return true;
            }
        }
        return false;
    }


    public boolean deleteTeacher(String id) {
        return teachers.removeIf(teacher -> teacher.getId().equals(id));
    }


    public boolean addCourseToTeacher(String id, String course) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                teacher.addCourse(course);
                return true;
            }
        }
        return false;
    }


    public boolean removeCourseFromTeacher(String id, String course) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                teacher.removeCourse(course);
                return true;
            }
        }
        return false;
    }

}
