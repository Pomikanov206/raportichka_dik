package com.example.pomik.studentraportichka.datasource;

import com.example.pomik.studentraportichka.domain.usecase.model.Student;
import com.example.pomik.studentraportichka.domain.usecase.model.StudentGroup;

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
        int i = 1;
        students.add(new Student(i++,"Аврах І.А."));
        students.add(new Student(i++,"Гугучія М.П."));
        students.add(new Student(i++,"Ємельянов Д.Д."));
        students.add(new Student(i++,"Жулинський В.І."));
        students.add(new Student(i++,"Караюз Д.В."));
        students.add(new Student(i++,"Киричук М.Р."));
        students.add(new Student(i++,"Кривошеєв М.С."));
        students.add(new Student(i++,"Кулик М.Є."));
        students.add(new Student(i++,"Лакіза Н.Г."));
        students.add(new Student(i++,"Лимар Б.І."));
        students.add(new Student(i++,"Машков М.А."));
        students.add(new Student(i++,"Мєх В.Є."));
        students.add(new Student(i++,"Можний О.В."));
        students.add(new Student(i++,"Никитюк О.В."));
        students.add(new Student(i++,"Сафтюк А.І."));
        students.add(new Student(i++,"Сімакова В.А."));
        students.add(new Student(i++,"Федулов А.А."));
        students.add(new Student(i++,"Хомук К.С."));
        students.add(new Student(i++,"Чумак В.В."));
        students.add(new Student(i++,"Швець А.А."));
        students.add(new Student(i++,"Швець А.А."));
        students.add(new Student(i++,"Щербак А.І."));
        studentList.put("КС-17-1", students);

        students = new ArrayList<>();
        students.add(new Student(1,"Familaya1"));
        students.add(new Student(2,"Fami2"));
        students.add(new Student(3,"Familaya3"));
        studentList.put("КС-18-1", students);

        students = new ArrayList<>();
        students.add(new Student(1,"Агафонов І.В."));
        students.add(new Student(2,"Березін Д.О."));
        students.add(new Student(3,"Гладченко Р.А"));
        students.add(new Student(4,"Кислов Д. В."));
        students.add(new Student(5,"Кудряшов О.О."));
        students.add(new Student(6,"Кучеренко Р.О."));
        students.add(new Student(7,"Левицький Д.О."));
        students.add(new Student(8,"Павловський А.Р."));
        students.add(new Student(9,"Платонов Д.Г."));
        students.add(new Student(10,"Приймаков М.О."));
        students.add(new Student(11,"Рудайтес М.С."));
        students.add(new Student(12,"Рудик Є.Т."));
        students.add(new Student(13,"Сліпченко О.С."));
        students.add(new Student(14,"Слюсаренко М.М."));
        students.add(new Student(15,"Тіщенко В.В."));
        students.add(new Student(16,"Цап А.В."));
        students.add(new Student(17,"Шаповалов В.Ю."));
        students.add(new Student(18,"Явтушенко Є.Ю."));
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
