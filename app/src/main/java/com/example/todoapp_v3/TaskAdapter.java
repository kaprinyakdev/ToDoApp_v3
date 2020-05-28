package com.example.todoapp_v3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private List<Task> taskList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView text, creationDate;

        public MyViewHolder(View view){
            super(view);
            text = (TextView) view.findViewById(R.id.tasktext);
            creationDate = (TextView) view.findViewById(R.id.creationDate);
        }
    }

    public TaskAdapter(List<Task> tasksList){
        this.taskList = tasksList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.text.setText(task.getText());
        holder.creationDate.setText(task.getCreationDate().toString());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public void addTaskToList(Task t){
        taskList.add(t);

    }
}
