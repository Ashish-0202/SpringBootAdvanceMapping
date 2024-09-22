package com.ashish.SpringBootAdvanceMapping.Controller;

import com.ashish.SpringBootAdvanceMapping.Entity.Instructor;
import com.ashish.SpringBootAdvanceMapping.Repository.appDao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    private appDao dao;

    @GetMapping("/instructor/{id}")
    public Instructor find(@PathVariable("id") long id){
        return dao.find(id);
    }

    @GetMapping("/all")
    public List<Instructor> list(){
        return dao.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> create(@RequestBody Instructor instructor){
        dao.save(instructor);

        return ResponseEntity.ok("Instructor Details saved..!");
    }

}
