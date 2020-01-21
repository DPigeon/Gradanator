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
    ArrayList<String> coursesInfo;
    ArrayAdapter adapter;
    int numberOfRandomCourses = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);

        generateCourses();

        // Setting up the list view with its adapter
        adapter = new ArrayAdapter<String>(this, R.layout.activity_grade, R.id.gradeTextView, coursesInfo);
        ListView listView = findViewById(R.id.gradeListView);
        listView.setAdapter(adapter);
    }

    protected void generateCourses() {
        // Generate a random number of courses
        courses = new ArrayList<Course>();
        coursesInfo = new ArrayList<String>();
        Random rnd = new Random();
        int number = rnd.nextInt(numberOfRandomCourses) + 1; // Random from 1 to 5

        for (int i = 0; i < number; i++) {
            Course randomizedCourse = Course.generateRandomCourse();
            courses.add(randomizedCourse);
        }
        for (int i = 0; i < number; i++) {
            ArrayList<Assignment> assignments = courses.get(i).getAssignments();
            String rowString = "Course Title: " + courses.get(i).getCourseTitle() + "\n" +
                         "Assignments: \n" +
                         generateAssignments(assignments) +
                         calculateAverage(assignments);
            coursesInfo.add(rowString);
        }
    }

    protected String generateAssignments(ArrayList<Assignment> assignments) {
        String info = "";
        for (int i = 0; i < assignments.size(); i++) {
            String title = assignments.get(i).getAssignmentTitle();
            String grade = Integer.toString(assignments.get(i).getAssignmentGrade());
            info += title + ": " + grade + "\n";
        }
        return info;
    }

    protected String calculateAverage(ArrayList<Assignment> assignments) {
        double total = 0;
        double avg = 0;
        for (int i = 0; i < assignments.size(); i++) {
            total = assignments.get(i).getAssignmentGrade() + total;
        }

        if (assignments.size() != 0) {
            avg = total / assignments.size();
            return "\nAverage: " + Double.toString(avg);
        } else
            return "\nAverage: NaN";
    }

}
