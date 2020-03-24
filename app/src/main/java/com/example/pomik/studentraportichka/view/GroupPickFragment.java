package com.example.pomik.studentraportichka.view;

//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.model.StudentGroup;
import com.example.pomik.studentraportichka.adapter.StudentGroupListAdapter;

import java.util.ArrayList;

public class GroupPickFragment extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StudentGroupListAdapter studentGroupAdapter;
    private ArrayList<StudentGroup> studentGroups;

    public static final String[] groupsName = {"КС-17-1","КС-19-1", "KC-19-2/11"};
    public static final int[] buildings = {1,2,1};
    public static final int[] classRoms = {205,310,401};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_pick);
        studentGroups  = new ArrayList<>();

        for(int i = 0; i < groupsName.length; i++) {
            StudentGroup studentGroup = new StudentGroup();

            studentGroup.setGroupName(groupsName[i]);
            studentGroup.setBuilding(buildings[i]);
            studentGroup.setClassRoom(classRoms[i]);

            studentGroups.add(studentGroup);
        }

        studentGroupAdapter = new StudentGroupListAdapter(studentGroups);

        recyclerView = findViewById(R.id.group_pick_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentGroupAdapter);
    }
}
