package com.crud.Project.StudentController;
import com.crud.Project.StudentRep.StudentRepo;
import com.crud.Project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    //Assign Student details
    @Autowired
    StudentRepo studentRepo;

    //Create End Point using GetMapping here we are getting data from database
    @GetMapping("/Student")
    public List<Student> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students;
    }

    //Create End Point using GetMapping here we are getting data from database using @PathVariable Annotation
    @GetMapping("/Student/{id}")
    public Student getStudentById(@PathVariable int id) {
        Student student = studentRepo.findById(id).get();
        return student;
    }

    //Create End Point using PostMapping here we are setting data to database using @RequestBody Annotation
    @PostMapping("create")
    public void createStudent(@RequestBody Student student) {
        studentRepo.save(student);// Save Student in database
    }


    @DeleteMapping("delete/{id}")
    public void deleteStudentById(@PathVariable int id) {
        //studentRepo.deleteById(id); // Delete Student from database
        //studentRepo.findById(id).ifPresent(student -> studentRepo.delete(student));
        Student student = studentRepo.findById(id).get();
        studentRepo.delete(student);
    }

}
