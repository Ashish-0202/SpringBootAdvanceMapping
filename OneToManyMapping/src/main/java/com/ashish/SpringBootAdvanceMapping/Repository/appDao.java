package com.ashish.SpringBootAdvanceMapping.Repository;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import com.ashish.SpringBootAdvanceMapping.Entity.courses;
import com.ashish.SpringBootAdvanceMapping.Entity.instructor_details;
import com.ashish.SpringBootAdvanceMapping.Entity.student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface appDao {

    void save(Instructor instructor);

    Instructor find(long id);

    void deleteByID(long id);

    List<Instructor> getAll();

    instructor_details findbyId(long id);

    void deleteInsdByid(long id);

    courses getCourse(long id);

    void createCourse(courses tempCourse);

    courses getCourseWithStudent(long id);

    student getStudentWithCourse(long id);

    void updateCourse(courses tempCourse);

    void updateStudent(student tempStudent);
}
