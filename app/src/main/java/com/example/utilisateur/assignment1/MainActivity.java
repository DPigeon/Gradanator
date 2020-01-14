package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/*
 * Created by David
 * MainActivity Class
 */

public class MainActivity extends AppCompatActivity {

    protected Button profileButton, gradeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileButton = findViewById(R.id.profileButton);
        gradeButton = findViewById(R.id.gradeButton);
    }

    protected void goToActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class); // from the main activity to the profile class
        startActivity(intent);
    }
}
