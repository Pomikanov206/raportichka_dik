package com.example.pomik.studentraportichka.view;

//import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.adapter.StudentGroupListAdapter;
import com.example.pomik.studentraportichka.model.DemoTempFileManager;
import com.example.pomik.studentraportichka.model.Student;
import com.example.pomik.studentraportichka.model.StudentGroup;
import com.example.pomik.studentraportichka.model.TempFileManager;
import com.example.pomik.studentraportichka.presenter.GroupPickPresenter;

import java.util.List;
import java.util.Map;

public class GroupPickFragment extends AppCompatActivity implements GroupPickView{

    private RecyclerView recyclerView;
    private StudentGroupListAdapter studentGroupAdapter;
    private List<StudentGroup> studentGroups;
    private GroupPickPresenter presenter;

    public static final String[] groupsName = {"КС-17-1","КС-19-1", "KC-19-2/11"};
    public static final int[] buildings = {1,2,1};
    public static final int[] classRoms = {205,310,401};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_pick);
        //studentGroups  = new ArrayList<>();

        TempFileManager.getInstance().create(this.getApplicationContext());

        presenter = new GroupPickPresenter(this);

        studentGroups = presenter.getGroupList();

        studentGroupAdapter = new StudentGroupListAdapter(studentGroups);
        studentGroupAdapter.setGroupPickFragment(this);
        recyclerView = findViewById(R.id.group_pick_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentGroupAdapter);

        findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, List<Student>> allNoExistStudents = DemoTempFileManager.getInstance().getAllNoExistStudents();
                ;
            }
        });
    }

    /*
    public void onClick(View view) {
        Intent intent = new Intent(GroupPickFragment.this, StudentCheckListFragment.class);

        startActivity(intent);
    }
    */
    @Override
    public void changeBackground(boolean check) {

    }
}
