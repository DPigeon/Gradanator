package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
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

    protected SharedPreferenceHelper sharedPreferenceHelper;
    protected EditText nameEditText, ageEditText, stIdEditText;
    protected Button saveButton;
    int maxLengthName = 15, maxLengthAge = 2, maxLengthId = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPreferenceHelper = new SharedPreferenceHelper(ProfileActivity.this);

        setupUI();
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
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveProfile();
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setupUI() {
        nameEditText = findViewById(R.id.nameEditText);
        InputFilter[] FilterArrayName = new InputFilter[1];
        FilterArrayName[0] = new InputFilter.LengthFilter(maxLengthName);
        nameEditText.setFilters(FilterArrayName);

        ageEditText = findViewById(R.id.ageEditText);
        InputFilter[] FilterArrayAge = new InputFilter[1];
        FilterArrayAge[0] = new InputFilter.LengthFilter(maxLengthAge);
        ageEditText.setFilters(FilterArrayAge);

        stIdEditText = findViewById(R.id.stIdEditText);
        InputFilter[] FilterArrayId = new InputFilter[1];
        FilterArrayId[0] = new InputFilter.LengthFilter(maxLengthId);
        stIdEditText.setFilters(FilterArrayId);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setVisibility(View.INVISIBLE); // Set the save button invisible
    }

    protected void setTextEnabled(boolean enabled) { // Used to make all text editable or not
        nameEditText.setEnabled(enabled);
        ageEditText.setEnabled(enabled);
        stIdEditText.setEnabled(enabled);
    }

    protected void saveProfile() { // Fields not empty, age must be between 18-99,
        String name = nameEditText.getText().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());
        int id = Integer.parseInt(stIdEditText.getText().toString());

        if (nameEditText.length() < 1 || ageEditText.length() < 1 || stIdEditText.length() < 1 || age > 17 && age < 100)
                sharedPreferenceHelper.saveProfile(new Profile(name, age, id));
    }

}
