package com.example.StudentJpaStreamer.controller;


import com.example.StudentJpaStreamer.entity.Student;
import com.example.StudentJpaStreamer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    //adding student deatils to database
    @PostMapping
    public Student addStudentDetails(@RequestBody Student student)
    {
        return studentService.addStudentDetails(student);
    }


    // get the count of registered student details for particular course
//    @GetMapping("/c/{Courses}")
//    public Map<String, Long> getCountofRegdStudents(@PathVariable List<String> courses)
//    {
//        return studentService.getCountofRegdStudents(courses);
//    }

    @GetMapping("/courses/{courseName}/count")
    public ResponseEntity<Long> getCountOfRegisteredStudentsForCourse(@PathVariable String courseName) {
        long count = studentService.getCountOfRegisteredStudentsForCourse(courseName);
        return ResponseEntity.ok(count);
    }

    //seggregating student information as per location

    @GetMapping("/a/{address}")
    public Map<String, List<Student>> getStudentDetailsByAddress(@PathVariable String address)
    {
        return studentService.getStudentDetailsByAddress(address);
    }


}
