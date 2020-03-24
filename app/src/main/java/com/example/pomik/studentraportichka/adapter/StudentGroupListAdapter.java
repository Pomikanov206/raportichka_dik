package com.example.pomik.studentraportichka.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.model.StudentGroup;

import java.util.List;

public class StudentGroupListAdapter extends RecyclerView.Adapter<StudentGroupListAdapter.StudentGroupViewHolder> {

    List<StudentGroup> studentGroupList;
    Context context;

    public StudentGroupListAdapter(List<StudentGroup> studentGroupsList) {
        this.studentGroupList = studentGroupsList;
    }

    @NonNull
    @Override
    public StudentGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_card,parent,false);
        StudentGroupViewHolder viewHolder = new StudentGroupViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentGroupViewHolder holder, int position) {
        StudentGroup group = studentGroupList.get(position);

        holder.groupName.setText(group.getGroupName());
        holder.building.setText("" + group.getBuilding());
        holder.classRoom.setText("" + group.getClassRoom());


    }

    @Override
    public int getItemCount() {
        return studentGroupList.size();
    }

    public static class StudentGroupViewHolder extends RecyclerView.ViewHolder {
        TextView groupName;
        TextView building;
        TextView classRoom;
        CardView cv;

        public StudentGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.group_title);
            building = itemView.findViewById(R.id.building);
            classRoom = itemView.findViewById(R.id.class_room);
            cv = itemView.findViewById(R.id.group_card);
        }
    }
}
