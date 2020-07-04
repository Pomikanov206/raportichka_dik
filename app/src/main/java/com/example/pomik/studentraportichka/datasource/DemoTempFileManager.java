package com.example.pomik.studentraportichka.datasource;

import com.example.pomik.studentraportichka.domain.usecase.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoTempFileManager {
    private static DemoTempFileManager instance;
    private Map<String, List<Student>> noExistStudents;

    private DemoTempFileManager() {
        noExistStudents = new HashMap<>();
    }

    public void save(String group, Student student) {
        if (noExistStudents.containsKey(group))
            noExistStudents.get(group).add(student);
        else {
            ArrayList<Student> list = new ArrayList<Student>();
            list.add(student);
            noExistStudents.put(group, list);
        }
    }

    public void saveGroup(String group, List<Student> students) {
        noExistStudents.put(group, students);
    }

    public void load() {

    }

    public Map<String, List<Student>> getAllNoExistStudents() {
        return noExistStudents;
    }

    public static DemoTempFileManager getInstance() {
        if (instance == null)
            instance = new DemoTempFileManager();
        return instance;
    }
}
