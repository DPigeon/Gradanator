package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

/*
 * Created by David
 * GradeActivity Class Child of the MainActivity
 * Generates 1 to 5 course + assignments and displays them
 * Converts % to letters for grades
 */

public class GradeActivity extends AppCompatActivity {
    ArrayList<Course> courses;
    ArrayList<String> coursesString;
    ArrayAdapter adapter;
    int numberOfRandomCourses = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        generateCourses();

        // Setting up the list view with its adapter
        adapter = new ArrayAdapter<String>(this, R.layout.activity_grade, R.id.gradeTextView, coursesString);
        ListView listView = findViewById(R.id.gradeListView);
        listView.setAdapter(adapter);
    }

    protected void generateCourses() {
        // Generate a random number of courses
        courses = new ArrayList<Course>();
        coursesString = new ArrayList<String>();
        Random rnd = new Random();
        int number = rnd.nextInt(numberOfRandomCourses) + 1; // Random from 1 to 5

        for (int i = 0; i < number; i++) {
            Course randomizedCourse = Course.generateRandomCourse();
            courses.add(randomizedCourse);
            String courseTitle = courses.get(i).getCourseTitle();
            coursesString.add(courseTitle);
            ArrayList<Assignment> assignments = randomizedCourse.getAssignments();
            for (int j = 0; j < assignments.size(); j++) {
                String assignmentTitle = assignments.get(j).getAssignmentTitle();
                int assignmentGrade = assignments.get(j).getAssignmentGrade();
                coursesString.add(assignmentTitle + "     " + assignmentGrade);
            }
        }
    }
}
