package com.example.pomik.studentraportichka.presenter;

import com.example.pomik.studentraportichka.model.DataBaseDemo;
import com.example.pomik.studentraportichka.model.DataBaseReader;
import com.example.pomik.studentraportichka.model.StudentGroup;
import com.example.pomik.studentraportichka.view.GroupPickView;

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
