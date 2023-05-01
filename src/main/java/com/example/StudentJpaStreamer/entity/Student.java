package com.example.StudentJpaStreamer.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_tab")
public class Student {
    @Id
    private String studentId;
    private String studentName;
    private String studentEmail;
    private String studentPhoneNo;
    private String qualification;
    private String workExperience;
    @ElementCollection
    private List<String> Courses;

    private String address;
    private String comment;
}
