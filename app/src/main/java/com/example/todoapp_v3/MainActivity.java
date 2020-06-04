package com.example.todoapp_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Task> taskList = new ArrayList<>();
    private TaskAdapter taskAdapter;
    private int listPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        taskAdapter = new TaskAdapter(taskList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(taskAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Task task = taskList.get(position);
                //Toast.makeText(getApplicationContext(), task.getText() + " is selected!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), taskAdapter.getItemCount() + "is asd", Toast.LENGTH_SHORT).show();
                listPosition = position;

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareTaskData();


        Button addNewTask = (Button) findViewById(R.id.addNewTask);
        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task t = new Task("asd","asd2");
                TextView newTaskText = (TextView) findViewById(R.id.newTaskText);
                String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
                Task p = new Task(newTaskText.getText().toString(),currentDateTimeString);
                taskAdapter.addTaskToList(p);
                taskAdapter.notifyDataSetChanged();
            }
        });

        Button deleteTask = (Button) findViewById(R.id.deleteTask);
        deleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskAdapter.deleteTaskFromList(listPosition);
                taskAdapter.notifyDataSetChanged();
            };
        });

    }

    private void prepareTaskData(){
        Task task = new Task("első","asd");
        taskList.add(task);

        task = new Task("második","dsa");
        taskList.add(task);

        taskAdapter.notifyDataSetChanged();
    }

}
