package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Created by David
 * MainActivity Class
 */

public class MainActivity extends AppCompatActivity {

    protected SharedPreferenceHelper sharedPreferenceHelper;
    protected Button profileButton, gradeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);

        setupUI(profileButton, R.id.profileButton, ProfileActivity.class);
        setupUI(gradeButton, R.id.gradeButton, GradeActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String profileName = sharedPreferenceHelper.getProfileName();
        if (profileName == null)
            goToActivity(ProfileActivity.class); // If no name, go to the profile
        else
            profileButton.setText(profileName); // Otherwise just set the stored name
    }

    protected void setupUI(Button button, int id, final Class page) {
        button = findViewById(id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(page);
            }
        });
    }

    protected void goToActivity(Class page) {
        Intent intent = new Intent(MainActivity.this, page); // from the main activity to the profile class
        startActivity(intent);
    }
}
