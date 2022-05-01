package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SundayWorkout extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listElements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_workout);

        listView = findViewById(R.id.listValue);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SundayWorkout.this);
        String message = prefs.getString("sunday", "");

        listElements.add(message);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listElements);
        listView.setAdapter(adapter);

        initToolbar();
    }

    private void initToolbar() {
        getSupportActionBar().setTitle("Sunday Workouts");
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