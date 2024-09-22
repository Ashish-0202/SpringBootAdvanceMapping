package com.ashish.SpringBootAdvanceMapping.Repository;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import com.ashish.SpringBootAdvanceMapping.Entity.instructor_details;
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
}
