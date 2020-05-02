package com.example.pomik.studentraportichka.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.adapter.StudentListAdapter;
import com.example.pomik.studentraportichka.model.DataBaseDemo;
import com.example.pomik.studentraportichka.model.DemoTempFileManager;
import com.example.pomik.studentraportichka.model.Student;
import com.example.pomik.studentraportichka.presenter.StudentCheckListPresenter;

import java.util.List;

public class StudentCheckListFragment extends AppCompatActivity implements CheckListView{
    private RecyclerView recyclerView;
    private StudentListAdapter studentListAdapter;
    private List<Student> studentList;
    private StudentCheckListPresenter presenter;

    private static final String[] studentNames = {"Agafonof I.", "Berezin D.", "Priymakov M."};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        presenter = new StudentCheckListPresenter(this);

        Intent intent = getIntent();
        final String groupName = intent.getStringExtra("GROUP");
        studentList = presenter.getStudentList(groupName);

        studentListAdapter = new StudentListAdapter(studentList);

        recyclerView = findViewById(R.id.student_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentListAdapter);

        findViewById(R.id.submit_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Student> missingStudents = studentListAdapter.getMissingStudents();
                DemoTempFileManager.getInstance().saveGroup(groupName, missingStudents);
                finish();
            }
        });
    }
}
