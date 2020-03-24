package com.example.pomik.studentraportichka.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.adapter.StudentListAdapter;
import com.example.pomik.studentraportichka.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentCheckListFragment extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StudentListAdapter studentListAdapter;
    private List<Student> studentList;

    private static final String[] studentNames = {"Agafonof I.", "Berezin D.", "Priymakov M."};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        studentList = new ArrayList<>();

        for (int i = 0; i < studentNames.length; i++) {
            Student student = new Student();
            student.setId(i+1);
            student.setName(studentNames[i]);

            studentList.add(student);
        }

        studentListAdapter = new StudentListAdapter(studentList);

        recyclerView = findViewById(R.id.student_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentListAdapter);
    }
}
