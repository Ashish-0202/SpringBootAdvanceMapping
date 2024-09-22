package com.ashish.SpringBootAdvanceMapping.Repository;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import com.ashish.SpringBootAdvanceMapping.Entity.instructor_details;
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
        return entityManager.find(Instructor.class,id);
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


}
