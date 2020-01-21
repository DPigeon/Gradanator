package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    boolean convertMode;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Creates the three dot action menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        if(menuId == R.id.action_settings) { // If we click on the ... button
            // Convert Grades
            convertMode = !convertMode; // Toggling the mode
        }
        return super.onOptionsItemSelected(item);
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
            coursesInfo.add(rowString); // Adding everything in a String ArrayList
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
            total = assignments.get(i).getAssignmentGrade() + total; // Calculating the total grade
        }

        if (assignments.size() != 0) { // Avoiding division by 0
            avg = total / assignments.size();
            return "\nAverage: " + Double.toString(avg);
        } else
            return "\nAverage: NaN";
    }

    protected String convertGrade(double grade) {
        if (grade >= 90 && grade <= 100)
            return "A+";
        else if (grade >= 85 && grade <= 89)
            return "A";
        else if (grade >= 80 && grade <= 84)
            return "A-";
        else if (grade >= 77 && grade <= 79)
            return "B+";
        else if (grade >= 73 && grade <= 76)
            return "B";
        else if (grade >= 70 && grade <= 72)
            return "B-";
        else if (grade >= 67 && grade <= 69)
            return "C+";
        else if (grade >= 63 && grade <= 66)
            return "C";
        else if (grade >= 60 && grade <= 62)
            return "C-";
        else if (grade >= 57 && grade <= 59)
            return "D+";
        else if (grade >= 53 && grade <= 56)
            return "D";
        else if (grade >= 50 && grade <= 52)
            return "D-";
        else
            return "F";
    }

}
