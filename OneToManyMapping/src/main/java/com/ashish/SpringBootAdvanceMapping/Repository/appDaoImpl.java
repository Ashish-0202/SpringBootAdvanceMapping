package com.ashish.SpringBootAdvanceMapping.Repository;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import com.ashish.SpringBootAdvanceMapping.Entity.courses;
import com.ashish.SpringBootAdvanceMapping.Entity.instructor_details;
import com.ashish.SpringBootAdvanceMapping.Entity.student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class appDaoImpl implements appDao{

    private EntityManager entityManager;

    @Autowired
    public appDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    //We are performing an update operation in DB
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor find(long id) {
        //return entityManager.find(Instructor.class,id);
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:id", Instructor.class);

        query.setParameter("id",id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    //Making modification to DB so user @Transactional
    public void deleteByID(long id) {
        Instructor instructor= entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);
    }

    @Override
    public List<Instructor> getAll() {
        TypedQuery<Instructor> query = entityManager.createQuery("from instructor", Instructor.class);
        List<Instructor> all = query.getResultList();
        return all;
    }

    @Override
    public instructor_details findbyId(long id) {
        return entityManager.find(instructor_details.class,id);
    }

    @Override
    @Transactional
    public void deleteInsdByid(long id) {
        instructor_details instructorDetails= entityManager.find(instructor_details.class,id);
        entityManager.remove(instructorDetails);
    }

    @Override
    public courses getCourse(long id) {
        return entityManager.find(courses.class,id);
    }

    @Override
    @Transactional
    public void createCourse(courses tempCourse) {
        entityManager.persist(tempCourse);
    }

    @Override
    public courses getCourseWithStudent(long id) {
        TypedQuery<courses> query = entityManager.createQuery("select c from courses c JOIN FETCH c.students where c.id=:cid", courses.class);
        query.setParameter("cid",id);
        return query.getSingleResult();
    }

    @Override
    public student getStudentWithCourse(long id) {
        TypedQuery<student> query = entityManager.createQuery("select s from student s JOIN FETCH s.courses where s.sid=:id", student.class);

        query.setParameter("id",id);

        student s1= query.getSingleResult();

        return s1;
    }

    @Override
    @Transactional
    public void updateCourse(courses tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    @Transactional
    public void updateStudent(student tempStudent) {
        entityManager.merge(tempStudent);
    }

}
