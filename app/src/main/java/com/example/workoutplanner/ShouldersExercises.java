package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class ShouldersExercises extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        setUpUiViews();
        initToolbar();
        setUpListView();

    }

    private void setUpUiViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarWorkoutList);
        listView = (ListView) findViewById(R.id.listviewWorkoutList);
    }

    private void initToolbar() {
        getSupportActionBar();
        getSupportActionBar().setTitle("Shoulder Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.ShoulderExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        shoulderPressDialog();
                        break;
                    }
                    case 1: {
                        frontRaiseDialog();
                        break;
                    }
                    case 2: {
                        lateralRaiseDialog();
                        break;
                    }
                    case 3: {
                        shrugsDialog();
                        break;
                    }
                    case 4: {
                        cableCrossoverDialog();
                        break;
                    }
                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title;
        private String[] titleArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title) {
            mContext = context;
            titleArray = title;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int i) {
            return titleArray[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = layoutInflater.inflate(R.layout.activity_workoutlist_layout, null);
            }

            title = (TextView) view.findViewById(R.id.workoutArea);
            imageView = (ImageView) view.findViewById(R.id.workoutListImage);

            title.setText(titleArray[i]);

            if (titleArray[i].equalsIgnoreCase("Shoulder Press")) {
                imageView.setImageResource(R.drawable.shoulder_press);
            } else if (titleArray[i].equalsIgnoreCase("Front Raise")) {
                imageView.setImageResource(R.drawable.front_raise);
            } else if (titleArray[i].equalsIgnoreCase("Lateral Raise")) {
                imageView.setImageResource(R.drawable.lateral_raises);
            } else if (titleArray[i].equalsIgnoreCase("Cable Crossover")) {
                imageView.setImageResource(R.drawable.cable_crossover);
            } else if (titleArray[i].equalsIgnoreCase("Shrugs")) {
                imageView.setImageResource(R.drawable.shrugs);
            }
            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void shoulderPressDialog() {
        ShoulderPressDialog shoulderPressDialog = new ShoulderPressDialog();
        shoulderPressDialog.show(getSupportFragmentManager(), "shoulder press dialog");
    }

    private void frontRaiseDialog() {
        FrontRaiseDialog frontRaiseDialog = new FrontRaiseDialog();
        frontRaiseDialog.show(getSupportFragmentManager(), "front raise dialog");
    }

    private void lateralRaiseDialog() {
        LateralRaiseDialog lateralRaiseDialog = new LateralRaiseDialog();
        lateralRaiseDialog.show(getSupportFragmentManager(), "lateral raise dialog");
    }

    private void cableCrossoverDialog() {
        CableCrossoverDialog cableCrossoverDialog = new CableCrossoverDialog();
        cableCrossoverDialog.show(getSupportFragmentManager(), "cable crossover dialog");
    }

    private void shrugsDialog() {
        ShrugsDialog shrugsDialog = new ShrugsDialog();
        shrugsDialog.show(getSupportFragmentManager(), "shrugs dialog");
    }

}