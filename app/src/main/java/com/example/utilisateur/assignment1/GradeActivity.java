package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/*
 * Created by David
 * GradeActivity Class Child of the MainActivity
 */

public class GradeActivity extends AppCompatActivity {
    ArrayList<Course> courses;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        // Setting up the list view with its adapter
        adapter = new ArrayAdapter<Course>(this, R.layout.activity_grade, courses);
        ListView listView = findViewById(R.id.gradeListView);
        listView.setAdapter(adapter);
    }
}
