package com.example.pomik.studentraportichka.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseDemo implements DataBaseReader{

    private  List<StudentGroup> groupList;
    private  Map<String, ArrayList<Student>> studentList;
    private static DataBaseDemo instance = null;

    private DataBaseDemo()  {
        groupList = new ArrayList<>();
        groupList.add(new StudentGroup("КС-17-1",1,401));
        groupList.add(new StudentGroup("КС-18-1",2,208));
        groupList.add(new StudentGroup("КС-19-2/11",1,404));
        groupList.add(new StudentGroup("КС-18-2/11",2,412));

        studentList = new HashMap<>();

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"Lakiza"));
        students.add(new Student(2,"Cosmos Lakiza"));
        students.add(new Student(3,"Army Lakiza"));
        studentList.put("КС-17-1", students);

        students = new ArrayList<>();
        students.add(new Student(1,"Familaya1"));
        students.add(new Student(2,"Fami2"));
        students.add(new Student(3,"Familaya3"));
        studentList.put("КС-18-1", students);

        students = new ArrayList<>();
        students.add(new Student(1,"MArk"));
        students.add(new Student(2,"Bereza"));
        students.add(new Student(3,"Rudik"));
        studentList.put("КС-19-2/11", students);

        students = new ArrayList<>();
        students.add(new Student(1,"Yura"));
        students.add(new Student(2,"Dancov"));
        students.add(new Student(3,"Vasua"));
        studentList.put("КС-18-2/11", students);
    }

    public  List<StudentGroup> getGroups() {
        return groupList;
    }

    @Override
    public List<Student> getStudents(String group) {
        return studentList.get(group);
    }

    public static DataBaseDemo getInstance() {
        if(instance == null)
            instance = new DataBaseDemo();
        return instance;
    }
}
