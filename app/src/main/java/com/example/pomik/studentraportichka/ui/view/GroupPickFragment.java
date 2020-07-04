package com.example.pomik.studentraportichka.ui.view;

//import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.datasource.file.CSVFileCreator;
import com.example.pomik.studentraportichka.datasource.file.FileCreator;
import com.example.pomik.studentraportichka.datasource.file.HTMLFileCreator;
import com.example.pomik.studentraportichka.ui.view.adapter.ViewStudentGroupListAdapter;
import com.example.pomik.studentraportichka.datasource.DemoTempFileManager;
import com.example.pomik.studentraportichka.domain.usecase.model.Student;
import com.example.pomik.studentraportichka.domain.usecase.model.StudentGroup;
import com.example.pomik.studentraportichka.datasource.TempFileManager;
import com.example.pomik.studentraportichka.presenter.GroupPickPresenter;

import java.util.List;
import java.util.Map;

public class GroupPickFragment extends AppCompatActivity implements GroupPickView{

    private RecyclerView recyclerView;
    private ViewStudentGroupListAdapter studentGroupAdapter;
    private List<StudentGroup> studentGroups;
    private GroupPickPresenter presenter;

    public static final String[] groupsName = {"КС-17-1","КС-19-1", "KC-19-2/11"};
    public static final int[] buildings = {1,2,1};
    public static final int[] classRoms = {205,310,401};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_pick);

        presenter = new GroupPickPresenter(this);

        studentGroups = presenter.getGroupList();

        studentGroupAdapter = new ViewStudentGroupListAdapter(studentGroups);
        studentGroupAdapter.setGroupPickFragment(this);
        recyclerView = findViewById(R.id.group_pick_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentGroupAdapter);

        findViewById(R.id.csv_submit_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, List<Student>> allNoExistStudents = DemoTempFileManager.getInstance().getAllNoExistStudents();

                FileCreator fileCreator = new CSVFileCreator();
                fileCreator.templateMethod(getApplicationContext(), allNoExistStudents);

                Intent shareIntent = new Intent();
                shareIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareIntent.setAction(Intent.ACTION_SEND);
                Uri outputUri = FileProvider.getUriForFile(
                        getApplicationContext(),
                        getApplicationContext().getPackageName() + ".provider",
                        fileCreator.getFile());
                shareIntent.putExtra(Intent.EXTRA_STREAM, outputUri);
                shareIntent.setDataAndType(outputUri, "text/csv");
                startActivity(Intent.createChooser(shareIntent,"Поделится отчетом..."));
            }
        });
        findViewById(R.id.html_submit_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, List<Student>> allNoExistStudents = DemoTempFileManager.getInstance().getAllNoExistStudents();

                FileCreator fileCreator = new HTMLFileCreator();
                fileCreator.templateMethod(getApplicationContext(), allNoExistStudents);

                Intent shareIntent = new Intent();
                shareIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                shareIntent.setAction(Intent.ACTION_SEND);
                Uri outputUri = FileProvider.getUriForFile(
                        getApplicationContext(),
                        getApplicationContext().getPackageName() + ".provider",
                        fileCreator.getFile());
                shareIntent.putExtra(Intent.EXTRA_STREAM, outputUri);
                shareIntent.setDataAndType(outputUri, "text/html");
                startActivity(Intent.createChooser(shareIntent,"Поделится отчетом..."));
            }
        });
    }

    @Override
    public void changeBackground(boolean check) {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
