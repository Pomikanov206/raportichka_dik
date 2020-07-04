package com.example.pomik.studentraportichka.presenter;

import com.example.pomik.studentraportichka.datasource.DataBaseDemo;
import com.example.pomik.studentraportichka.datasource.DataBaseReader;
import com.example.pomik.studentraportichka.domain.usecase.model.StudentGroup;
import com.example.pomik.studentraportichka.ui.view.GroupPickView;

import java.util.List;

public class GroupPickPresenter {
    private GroupPickView view;
    private DataBaseReader model;

    public GroupPickPresenter(GroupPickView view) {
        this.view = view;
        model = DataBaseDemo.getInstance();
    }

    public List<StudentGroup> getGroupList() {
        return model.getGroups();
    }
}
