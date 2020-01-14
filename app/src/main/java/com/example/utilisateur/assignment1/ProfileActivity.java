package com.example.utilisateur.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/*
 * Created by David
 * ProfileActivity Class
 */

public class ProfileActivity extends AppCompatActivity {

    protected EditText nameEditText;
    protected EditText ageEditText;
    protected EditText stIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        stIdEditText = findViewById(R.id.stIdEditText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
