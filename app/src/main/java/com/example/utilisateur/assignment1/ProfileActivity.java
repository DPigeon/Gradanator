package com.example.utilisateur.assignment1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

/*
 * Created by David
 * ProfileActivity Class Child of the MainActivity
 */

public class ProfileActivity extends AppCompatActivity {

    protected SharedPreferenceHelper sharedPreferenceHelper;
    protected EditText nameEditText, ageEditText, stIdEditText;
    protected Button saveButton;
    int maxLengthName = 15, maxLengthAge = 2, maxLengthId = 6, minAge = 18, maxAge = 99; // For validation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPreferenceHelper = new SharedPreferenceHelper(ProfileActivity.this); // Instantiate the shared preferences for the profile activity

        setupUI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        setSavedText();
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
            switchMode(true, View.VISIBLE); // Switch to edit mode
        }
        return super.onOptionsItemSelected(item);
    }

    protected void setupUI() { // We setup all buttons and textEdits
        // Also setting up the maximum length of each textEdit field
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
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readInputs();
            }
        });
    }

    protected void switchMode(boolean enabled, int view) { // Toggle between display mode and edit mode
        nameEditText.setEnabled(enabled);
        ageEditText.setEnabled(enabled);
        stIdEditText.setEnabled(enabled);
        saveButton.setVisibility(view);
    }

    protected void setSavedText() {
        if (sharedPreferenceHelper.getProfile().getName() == null) { // Info does not exist
            switchMode(true, View.VISIBLE); // Switch to the edit mode
        }
        else {
            switchMode(false, View.INVISIBLE); // Switch to display mode

            // Getting the profile and displaying it
            Profile profile = sharedPreferenceHelper.getProfile();
            nameEditText.setText(profile.getName());
            ageEditText.setText(Integer.toString(profile.getAge()));
            stIdEditText.setText(Integer.toString(profile.getId()));
        }
    }

    protected void readInputs() { // Fields not empty, age must be between 18-99,
        // Reading the input from the edit text when the save button is pressed
        String name = nameEditText.getText().toString();
        String ageString = ageEditText.getText().toString();
        String idString = stIdEditText.getText().toString();

        int age = 0, id = 0;
        try { // We catch the errors if integers are null
            age = Integer.parseInt(ageEditText.getText().toString());
            id = Integer.parseInt(stIdEditText.getText().toString());
        } catch(NumberFormatException ex) {
        }

        validateAndSave(name, ageString, idString, age, id);
    }

    protected void validateAndSave(String name, String ageString, String idString, int age, int id) { // Validates input and saves to the sharedPreferences
        int idInt = 0;
        try { // We catch the errors if integers are null
            idInt = Integer.parseInt(idString);
        } catch(NumberFormatException ex) {
        }
        if (name.matches(""))
            toastMessage("Your username cannot be empty!");
        else if (ageString.matches(""))
            toastMessage("Your age cannot be empty!");
        else if (idString.matches(""))
            toastMessage("Your student ID cannot be empty!");
        else if (idInt < 1) // Maximum 6 digits and minimum number is 1
            toastMessage("Your student ID must be greater than 0!");
        else if (age < minAge || age > maxAge)
            toastMessage("You must be 18 to use this app!");
        else {
            sharedPreferenceHelper.saveProfile(new Profile(name, age, id)); // We save the profile
            switchMode(false, View.INVISIBLE); // Switch to the display mode
            toastMessage("Saved!");
        }
    }

    protected void toastMessage(String message) { // Shows a toast message
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG); // Current pointer to the add, the string and the length if stays on
        toast.show(); // We display it
    }

}
