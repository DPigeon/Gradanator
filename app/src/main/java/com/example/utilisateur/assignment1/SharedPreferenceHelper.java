package com.example.utilisateur.assignment1;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * Created by David from the assignment 1 page
 * The SharedPreferenceHelper Class
 * A controller in the MVC structure
 */

public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;

    public SharedPreferenceHelper(Context context) { // Constructor
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE);
    }

    // For the MainActivity
    public void saveProfileName(String name)  { // Save the profile name (Setter)
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ProfileName", name);
        editor.apply(); // Using apply instead of commit now
    }

    public String getProfileName() { // Getter for profile name
        return sharedPreferences.getString("ProfileName", null);
    }

    public void saveProfile(Profile profile) { // Setter for the profile object

    }

    public Profile getProfile() { // Getter for the profile object
        return new Profile("test", 10, 4039493);
    }
}
