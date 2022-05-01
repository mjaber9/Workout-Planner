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

public class BackExercises extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Back Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.BackExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        deadliftDialog();
                        break;
                    }
                    case 1: {
                        pullupDialog();
                        break;
                    }
                    case 2: {
                        latPulldownDialog();
                        break;
                    }
                    case 3: {
                        dumbbellRowDialog();
                        break;
                    }
                    case 4: {
                        reverseFlyDialog();
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

            if (titleArray[i].equalsIgnoreCase("Deadlift")) {
                imageView.setImageResource(R.drawable.deadlift);
            } else if (titleArray[i].equalsIgnoreCase("Pull Up")) {
                imageView.setImageResource(R.drawable.pull_up);
            } else if (titleArray[i].equalsIgnoreCase("Lat Pulldown")) {
                imageView.setImageResource(R.drawable.lat_pulldown);
            } else if (titleArray[i].equalsIgnoreCase("Dumbbell Row")) {
                imageView.setImageResource(R.drawable.dumbbell_row);
            } else if (titleArray[i].equalsIgnoreCase("Reverse Fly Machine")) {
                imageView.setImageResource(R.drawable.reverse_fly_machine);
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

    private void deadliftDialog() {
        DeadliftDialog deadliftDialog = new DeadliftDialog();
        deadliftDialog.show(getSupportFragmentManager(), "deadlift dialog");
    }

    private void pullupDialog() {
        PullupDialog pullupDialog = new PullupDialog();
        pullupDialog.show(getSupportFragmentManager(), "pull up dialog");
    }

    private void latPulldownDialog() {
        LatPulldownDialog latPulldownDialog = new LatPulldownDialog();
        latPulldownDialog.show(getSupportFragmentManager(), "lat pulldown dialog");
    }

    private void dumbbellRowDialog() {
        DumbbellRowDialog dumbbellRowDialog = new DumbbellRowDialog();
        dumbbellRowDialog.show(getSupportFragmentManager(), "dumbbell row dialog");
    }

    private void reverseFlyDialog() {
        ReverseFlyDialog reverseFlyDialog = new ReverseFlyDialog();
        reverseFlyDialog.show(getSupportFragmentManager(), "reverse fly dialog");
    }
}