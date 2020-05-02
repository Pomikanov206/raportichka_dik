package com.example.pomik.studentraportichka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentListAdapter extends Adapter<StudentListAdapter.StudentListViewHolder> {
    List<Student> studentList;
    Context context;
    private List<Student> missingStudents;

    public StudentListAdapter(List<Student> studentList) {
        this.studentList = studentList;
        missingStudents = new ArrayList<>();
    }

    @NonNull
    @Override
    public StudentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_item, parent, false);
        StudentListViewHolder viewHolder = new StudentListViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListViewHolder holder, int position) {
        final Student student = studentList.get(position);

        holder.studentNumber.setText("" + student.getId());
        holder.studentName.setText(student.getName());

        holder.studentCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    missingStudents.add(student);
                else
                    missingStudents.remove(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentListViewHolder extends ViewHolder {
        public final TextView studentNumber;
        public final TextView studentName;
        public final CheckBox studentCheck;

        public StudentListViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.studentNumber = itemView.findViewById(R.id.student_number);
            this.studentName = itemView.findViewById(R.id.student_name);
            this.studentCheck = itemView.findViewById(R.id.student_check);
        }
    }

    public List<Student> getMissingStudents() {
        return missingStudents;
    }
}
