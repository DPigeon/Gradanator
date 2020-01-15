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
    public void saveProfile(Profile profile)  { // Save the profile (Setter)
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ProfileName", profile.getName());
        editor.putInt("ProfileAge", profile.getAge());
        editor.putInt("ProfileId", profile.getId());
        editor.apply(); // Using apply instead of commit now
    }

    public Profile getProfile() { // Getter for profile
        String name = sharedPreferences.getString("ProfileName", null);
        int age = sharedPreferences.getInt("ProfileAge", 0);
        int id = sharedPreferences.getInt("ProfileId", 0);
        return new Profile(name, age, id);
    }
}
