package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SaturdayWorkout extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listElements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_workout);

        listView = findViewById(R.id.listValue);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SaturdayWorkout.this);
        String message = prefs.getString("saturday", "");

        listElements.add(message);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listElements);
        listView.setAdapter(adapter);

        initToolbar();
    }

    private void initToolbar() {
        getSupportActionBar().setTitle("Saturday Workouts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}