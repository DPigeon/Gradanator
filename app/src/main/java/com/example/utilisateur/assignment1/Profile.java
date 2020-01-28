package com.example.utilisateur.assignment1;

import android.content.Context;
import android.content.SharedPreferences;

/*
 * Created by David
 * Profile Class
 * A model in the MVC structure
 */

public class Profile {
    private String name;
    private int age, id;

    public Profile(String n, int a, int i) { // Constructor
        this.name = n;
        this.age = a;
        this.id = i;
    }

    /* Getters and Setters */
    public void setName(String n) {
        this.name = n;
    }

    public void setAge(int a) {
        this.age = a;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

}
