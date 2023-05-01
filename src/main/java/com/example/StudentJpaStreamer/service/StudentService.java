package com.example.StudentJpaStreamer.service;

import com.example.StudentJpaStreamer.StudentJpaStreamerApplication;
import com.example.StudentJpaStreamer.entity.Student;
import com.example.StudentJpaStreamer.repository.StudentRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private JPAStreamer jpaStreamer;


    @Autowired
    private StudentRepository studentRepository;
    public Student addStudentDetails(Student student) {
        return studentRepository.save(student);
    }

//    public long getCountofRegdStudents(String Courses) {
//
//        return jpaStreamer.stream(Student.class)
//                .filter(s -> s.getCourses().equals(Courses))
//                .count();
//    }

//    public Map<String, Long> getCountofRegdStudents(List<String> courses) {
//        Map<String, Long> counts = new HashMap<>();
//        for (String course : courses) {
//            long count = jpaStreamer.stream(Student.class)
//                    .filter(s -> s.getCourses().contains(course))
//                    .count();
//            counts.put(course, count);
//        }
//        return counts;
//    }

    public long getCountOfRegisteredStudentsForCourse(String courseName) {
        return jpaStreamer.stream(Student.class)
                .filter(s -> s.getCourses().contains(courseName))
                .count();
    }


    //seggregating student information as per location implementation
    public Map<String, List<Student>> getStudentDetailsByAddress(String address) {
        return jpaStreamer.stream(Student.class)
                .filter(s -> s.getAddress().equals(address))
                .collect(Collectors.groupingBy(Student::getAddress));
    }


}
