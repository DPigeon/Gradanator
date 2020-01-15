package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
 * Created by David
 * ProfileActivity Class
 */

public class ProfileActivity extends AppCompatActivity {

    protected EditText nameEditText, ageEditText, stIdEditText;
    protected Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        stIdEditText = findViewById(R.id.stIdEditText);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setVisibility(View.INVISIBLE); // Set the save button invisible
    }

    @Override
    protected void onStart() {
        super.onStart();
        setTextEnabled(false); // We set to not enabled as soon as we open the activity
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Creates the three dot action menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        if(menuId == R.id.action_settings){ // If we click on the ... button
            setTextEnabled(true); // Enable
            saveButton.setVisibility(View.VISIBLE); // Show the button
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setTextEnabled(boolean enabled) { // Used to make all text editable or not
        nameEditText.setEnabled(enabled);
        ageEditText.setEnabled(enabled);
        stIdEditText.setEnabled(enabled);
    }
}
