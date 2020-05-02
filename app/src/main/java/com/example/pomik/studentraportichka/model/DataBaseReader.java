package com.example.pomik.studentraportichka.model;

import java.util.List;

public interface DataBaseReader {
    List<StudentGroup> getGroups();
    List<Student> getStudents(String group);
}
