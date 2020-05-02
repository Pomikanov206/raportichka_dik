package com.example.pomik.studentraportichka.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pomik.studentraportichka.R;
import com.example.pomik.studentraportichka.model.StudentGroup;
import com.example.pomik.studentraportichka.view.GroupPickFragment;
import com.example.pomik.studentraportichka.view.StudentCheckListFragment;

import java.util.List;

public class StudentGroupListAdapter extends RecyclerView.Adapter<StudentGroupListAdapter.StudentGroupViewHolder> {

    List<StudentGroup> studentGroupList;
    Context context;
    private GroupPickFragment groupPickFragment;

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
    public void onBindViewHolder(@NonNull final StudentGroupViewHolder holder, int position) {
        final StudentGroup group = studentGroupList.get(position);

        holder.groupName.setText(group.getGroupName());
        holder.building.setText("" + group.getBuilding());
        holder.classRoom.setText("" + group.getClassRoom());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(groupPickFragment, StudentCheckListFragment.class);
                intent.putExtra("GROUP",group.getGroupName());
                groupPickFragment.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentGroupList.size();
    }

    public class StudentGroupViewHolder extends RecyclerView.ViewHolder{
        TextView groupName;
        TextView building;
        TextView classRoom;
        CardView cv;

        public StudentGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            groupName = itemView.findViewById(R.id.group_title);
            building = itemView.findViewById(R.id.building);
            classRoom = itemView.findViewById(R.id.class_room);
            cv = itemView.findViewById(R.id.group_card_view);

            /*
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(groupPickFragment, StudentCheckListFragment.class);
                    intent.putExtra("GROUP",groupName.getText().toString());
                    groupPickFragment.startActivity(intent);
                }
            });
            */
        }
    }
    public void setGroupPickFragment(GroupPickFragment groupPickFragment) {
        this.groupPickFragment = groupPickFragment;
    }
}
