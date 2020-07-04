package com.example.pomik.studentraportichka.datasource;

import com.example.pomik.studentraportichka.domain.usecase.model.Student;
import com.example.pomik.studentraportichka.domain.usecase.model.StudentGroup;

import java.util.List;

public interface DataBaseReader {
    List<StudentGroup> getGroups();
    List<Student> getStudents(String group);
}
