package com.example.pomik.studentraportichka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.model.Student;

import java.util.List;

public class StudentListAdapter extends Adapter<StudentListAdapter.StudentListViewHolder> {
    List<Student> studentList;
    Context context;

    public StudentListAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return StudentListViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListViewHolder holder, int position) {
        Student student = studentList.get(position);

        holder.studentNumber.setText("" + student.getId());
        holder.studentName.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class StudentListViewHolder extends ViewHolder {
        public final TextView studentNumber;
        public final TextView studentName;
        public final CheckBox studentCheck;

        public StudentListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.studentNumber = itemView.findViewById(R.id.student_number);
            this.studentName = itemView.findViewById(R.id.student_name);
            this.studentCheck = itemView.findViewById(R.id.student_check);
        }

        @NonNull
        public static StudentListViewHolder create(@NonNull ViewGroup parent) {
            return new StudentListViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.student_list_item, parent, false));
        }
    }
}
