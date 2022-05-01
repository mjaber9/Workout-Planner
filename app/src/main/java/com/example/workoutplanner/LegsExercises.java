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

public class LegsExercises extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Leg Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.LegExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        squatsDialog();
                        break;
                    }
                    case 1: {
                        legPressDialog();
                        break;
                    }
                    case 2: {
                        lungesDialog();
                        break;
                    }
                    case 3: {
                        hamstringCurlDialog();
                        break;
                    }
                    case 4: {
                        calfRaiseDialog();
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

            if (titleArray[i].equalsIgnoreCase("Squats")) {
                imageView.setImageResource(R.drawable.squats);
            } else if (titleArray[i].equalsIgnoreCase("Leg Press")) {
                imageView.setImageResource(R.drawable.leg_press);
            } else if (titleArray[i].equalsIgnoreCase("Lunges")) {
                imageView.setImageResource(R.drawable.lunges);
            } else if (titleArray[i].equalsIgnoreCase("Hamstring Curl")) {
                imageView.setImageResource(R.drawable.hamstring_curl);
            } else if (titleArray[i].equalsIgnoreCase("Calf Raise")) {
                imageView.setImageResource(R.drawable.calf_raise);
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

    private void squatsDialog() {
        SquatsDialog squatsDialog = new SquatsDialog();
        squatsDialog.show(getSupportFragmentManager(), "squats dialog");
    }

    private void legPressDialog() {
        LegPressDialog legPressDialog = new LegPressDialog();
        legPressDialog.show(getSupportFragmentManager(), "leg press dialog");
    }

    private void lungesDialog() {
        LungesDialog lungesDialog = new LungesDialog();
        lungesDialog.show(getSupportFragmentManager(), "lunges dialog");
    }

    private void hamstringCurlDialog() {
        HamstringCurlDialog hamstringCurlDialog = new HamstringCurlDialog();
        hamstringCurlDialog.show(getSupportFragmentManager(), "hamstring curl dialog");
    }

    private void calfRaiseDialog() {
        CalfRaiseDialog calfRaiseDialog = new CalfRaiseDialog();
        calfRaiseDialog.show(getSupportFragmentManager(), "calf raise dialog");
    }

}