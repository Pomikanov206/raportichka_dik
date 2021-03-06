package com.example.pomik.studentraportichka.presenter;

import com.example.pomik.studentraportichka.datasource.DataBaseDemo;
import com.example.pomik.studentraportichka.datasource.DataBaseReader;
import com.example.pomik.studentraportichka.domain.usecase.model.Student;
import com.example.pomik.studentraportichka.ui.view.CheckListView;

import java.util.List;

public class StudentCheckListPresenter {
    private CheckListView view;
    private DataBaseReader model;

    public StudentCheckListPresenter(CheckListView view) {
        this.view = view;
        model = DataBaseDemo.getInstance();
    }

    public List<Student> getStudentList(String group) {
        return model.getStudents(group);
    }
}
