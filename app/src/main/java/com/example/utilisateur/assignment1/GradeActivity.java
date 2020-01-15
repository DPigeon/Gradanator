package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

/*
 * Created by David
 * GradeActivity Class
 */

public class GradeActivity extends AppCompatActivity {
    ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
    }
}
