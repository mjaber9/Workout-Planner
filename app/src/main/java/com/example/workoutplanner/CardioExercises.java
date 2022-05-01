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

public class CardioExercises extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Cardio Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.CardioExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        treadmillDialog();
                        break;
                    }
                    case 1: {
                        jumpropeDialog();
                        break;
                    }
                    case 2: {
                        ellipticalMachineDialog();
                        break;
                    }
                    case 3: {
                        exerciseBikeDialog();
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

            if (titleArray[i].equalsIgnoreCase("Treadmill")) {
                imageView.setImageResource(R.drawable.treadmill);
            } else if (titleArray[i].equalsIgnoreCase("Jump Rope")) {
                imageView.setImageResource(R.drawable.jump_rope);
            } else if (titleArray[i].equalsIgnoreCase("Elliptical Machine")) {
                imageView.setImageResource(R.drawable.elliptical_machine);
            } else if (titleArray[i].equalsIgnoreCase("Exercise Bike")) {
                imageView.setImageResource(R.drawable.exercise_bike);
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

    private void treadmillDialog() {
        TreadmillDialog treadmillDialog = new TreadmillDialog();
        treadmillDialog.show(getSupportFragmentManager(), "treadmill dialog");
    }

    private void jumpropeDialog() {
        JumpropeDialog jumpropeDialog = new JumpropeDialog();
        jumpropeDialog.show(getSupportFragmentManager(), "jumprope dialog");
    }

    private void ellipticalMachineDialog() {
        EllipticalMachineDialog ellipticalMachineDialog = new EllipticalMachineDialog();
        ellipticalMachineDialog.show(getSupportFragmentManager(), "elliptical machine dialog");
    }

    private void exerciseBikeDialog() {
        ExerciseBikeDialog exerciseBikeDialog = new ExerciseBikeDialog();
        exerciseBikeDialog.show(getSupportFragmentManager(), "exercise bike dialog");
    }
}