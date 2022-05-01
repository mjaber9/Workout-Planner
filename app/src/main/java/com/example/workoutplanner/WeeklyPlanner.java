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

public class WeeklyPlanner extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_selector);

        setUpUIViews();
        initToolbar();
        setUpListView();

    }

    private void setUpUIViews() {
        toolbar = (Toolbar) findViewById(R.id.ToolbarWeek);
        listView = (ListView) findViewById(R.id.listviewWeek);
    }

    private void initToolbar() {
        getSupportActionBar();
        getSupportActionBar().setTitle("Select your day");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] week = getResources().getStringArray(R.array.DaySelector);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, week);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0: {
                        Intent intent = new Intent(WeeklyPlanner.this, SundayWorkout.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: {
                        Intent intent = new Intent(WeeklyPlanner.this, MondayWorkout.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: {
                        Intent intent = new Intent(WeeklyPlanner.this, TuesdayWorkout.class);
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        Intent intent = new Intent(WeeklyPlanner.this, WednesdayWorkout.class);
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        Intent intent = new Intent(WeeklyPlanner.this, ThursdayWorkout.class);
                        startActivity(intent);
                        break;
                    }
                    case 5: {
                        Intent intent = new Intent(WeeklyPlanner.this, FridayWorkout.class);
                        startActivity(intent);
                        break;
                    }
                    case 6: {
                        Intent intent = new Intent(WeeklyPlanner.this, SaturdayWorkout.class);
                        startActivity(intent);
                        break;
                    }
                    default:break;
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
                view = layoutInflater.inflate(R.layout.activity_day_selector_layout, null);
            }

            title = (TextView)view.findViewById(R.id.dayOfWeek);
            imageView = (ImageView)view.findViewById(R.id.daysImage);

            title.setText(titleArray[i]);

            if(titleArray[i].equalsIgnoreCase("Sunday")) {
                imageView.setImageResource(R.drawable.sunday);
            } else if (titleArray[i].equalsIgnoreCase("Monday")) {
                imageView.setImageResource(R.drawable.monday);
            } else if (titleArray[i].equalsIgnoreCase("Tuesday")) {
                imageView.setImageResource(R.drawable.tuesday);
            } else if (titleArray[i].equalsIgnoreCase("Wednesday")) {
                imageView.setImageResource(R.drawable.wednesday);
            } else if (titleArray[i].equalsIgnoreCase("Thursday")) {
                imageView.setImageResource(R.drawable.thursday);
            } else if (titleArray[i].equalsIgnoreCase("Friday")) {
                imageView.setImageResource(R.drawable.friday);
            } else if (titleArray[i].equalsIgnoreCase("Saturday")) {
                imageView.setImageResource(R.drawable.saturday);
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