package com.example.workoutplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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

public class WorkoutList extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Area of Exercise");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.WorkoutList);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0: {
                        Intent intent = new Intent(WorkoutList.this, CardioExercises.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(WorkoutList.this, BackExercises.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent(WorkoutList.this, ChestExercises.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent = new Intent(WorkoutList.this, BicepsExercises.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent = new Intent(WorkoutList.this, TricepsExercises.class);
                        startActivity(intent);
                        break;
                    }
                    case 5: {
                        Intent intent = new Intent(WorkoutList.this, ShouldersExercises.class);
                        startActivity(intent);
                        break;
                    }
                    case 6: {
                        Intent intent = new Intent(WorkoutList.this, LegsExercises.class);
                        startActivity(intent);
                        break;
                    }
                    case 7: {
                        Intent intent = new Intent(WorkoutList.this, CoreExercises.class);
                        startActivity(intent);
                        break;
                    }
                    default: break;
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
            if(view == null) {
                view = layoutInflater.inflate(R.layout.activity_workoutlist_layout, null);
            }

            title = (TextView)view.findViewById(R.id.workoutArea);
            imageView = (ImageView)view.findViewById(R.id.workoutListImage);

            title.setText(titleArray[i]);

            if(titleArray[i].equalsIgnoreCase("Cardio")) {
                imageView.setImageResource(R.drawable.cardio);
            } else if (titleArray[i].equalsIgnoreCase("Back")) {
                imageView.setImageResource(R.drawable.back);
            } else if (titleArray[i].equalsIgnoreCase("Chest")) {
                imageView.setImageResource(R.drawable.chest);
            } else if (titleArray[i].equalsIgnoreCase("Biceps")) {
                imageView.setImageResource(R.drawable.bicep);
            } else if (titleArray[i].equalsIgnoreCase("Triceps")) {
                    imageView.setImageResource(R.drawable.triceps);
            } else if (titleArray[i].equalsIgnoreCase("Shoulders")) {
                imageView.setImageResource(R.drawable.shoulders);
            } else if (titleArray[i].equalsIgnoreCase("Legs")) {
                imageView.setImageResource(R.drawable.legs);
            } else if (titleArray[i].equalsIgnoreCase("Core")) {
                imageView.setImageResource(R.drawable.core);
            }

            return view;
        }
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