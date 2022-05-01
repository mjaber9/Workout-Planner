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

public class CoreExercises extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Core Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.CoreExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        sitUpsDialog();
                        break;
                    }
                    case 1: {
                        planksDialog();
                        break;
                    }
                    case 2: {
                        russianTwistDialog();
                        break;
                    }
                    case 3: {
                        legRaiseDialog();
                        break;
                    }
                    case 4: {
                        sideBendDialog();
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

            if (titleArray[i].equalsIgnoreCase("Sit Ups")) {
                imageView.setImageResource(R.drawable.sit_ups);
            } else if (titleArray[i].equalsIgnoreCase("Planks")) {
                imageView.setImageResource(R.drawable.planks);
            } else if (titleArray[i].equalsIgnoreCase("Russian Twist")) {
                imageView.setImageResource(R.drawable.russian_twist);
            } else if (titleArray[i].equalsIgnoreCase("Leg Raise")) {
                imageView.setImageResource(R.drawable.leg_raise);
            } else if (titleArray[i].equalsIgnoreCase("Side Bend")) {
                imageView.setImageResource(R.drawable.side_bend);
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

    private void sitUpsDialog() {
        SitUpsDialog sitUpsDialog = new SitUpsDialog();
        sitUpsDialog.show(getSupportFragmentManager(), "sit ups dialog");
    }

    private void planksDialog() {
        PlanksDialog planksDialog = new PlanksDialog();
        planksDialog.show(getSupportFragmentManager(), "planks dialog");
    }

    private void russianTwistDialog() {
        RussianTwistDialog russianTwistDialog = new RussianTwistDialog();
        russianTwistDialog.show(getSupportFragmentManager(), "russian twist dialog");
    }

    private void legRaiseDialog() {
        LegRaiseDialog legRaiseDialog = new LegRaiseDialog();
        legRaiseDialog.show(getSupportFragmentManager(), "leg raise dialog");
    }

    private void sideBendDialog() {
        SideBendDialog sideBendDialog = new SideBendDialog();
        sideBendDialog.show(getSupportFragmentManager(), "side bend dialog");
    }

}