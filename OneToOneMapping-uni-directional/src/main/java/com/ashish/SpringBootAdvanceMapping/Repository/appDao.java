package com.ashish.SpringBootAdvanceMapping.Repository;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface appDao {

    void save(Instructor instructor);

    Instructor find(long id);

    void deleteByID(long id);

    List<Instructor> getAll();
}
