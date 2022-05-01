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

public class ChestExercises extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Chest Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.ChestExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        benchpressDialog();
                        break;
                    }
                    case 1: {
                        dumbbellPressDialog();
                        break;
                    }
                    case 2: {
                        chestPressDialog();
                        break;
                    }
                    case 3: {
                        cableFlyDialog();
                        break;
                    }
                    case 4: {
                        pushUpsDialog();
                        break;
                    }
                    case 5: {
                        pecFlyDialog();
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

            if (titleArray[i].equalsIgnoreCase("Bench Press")) {
                imageView.setImageResource(R.drawable.bench_press);
            } else if (titleArray[i].equalsIgnoreCase("Dumbbell Press")) {
                imageView.setImageResource(R.drawable.dumbbell_press);
            } else if (titleArray[i].equalsIgnoreCase("Chest Press Machine")) {
                imageView.setImageResource(R.drawable.chest_press_machine);
            } else if (titleArray[i].equalsIgnoreCase("Cable Fly")) {
                imageView.setImageResource(R.drawable.cable_fly);
            } else if (titleArray[i].equalsIgnoreCase("Push Ups")) {
                imageView.setImageResource(R.drawable.push_ups);
            } else if (titleArray[i].equalsIgnoreCase("Pec Fly Machine")) {
                imageView.setImageResource(R.drawable.pec_fly_machine);
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

    private void benchpressDialog() {
        BenchpressDialog benchpressDialog = new BenchpressDialog();
        benchpressDialog.show(getSupportFragmentManager(), "benchpress dialog");
    }

    private void dumbbellPressDialog() {
        DumbbellPressDialog dumbbellPressDialog = new DumbbellPressDialog();
        dumbbellPressDialog.show(getSupportFragmentManager(), "dumbbell press dialog");
    }

    private void chestPressDialog() {
        ChestPressDialog chestPressDialog = new ChestPressDialog();
        chestPressDialog.show(getSupportFragmentManager(), "chest press dialog");
    }

    private void cableFlyDialog() {
        CableFlyDialog cableFlyDialog = new CableFlyDialog();
        cableFlyDialog.show(getSupportFragmentManager(), "cable fly dialog");
    }

    private void pushUpsDialog() {
        PushUpsDialog pushUpsDialog = new PushUpsDialog();
        pushUpsDialog.show(getSupportFragmentManager(), "push ups dialog");
    }

    private void pecFlyDialog() {
        PecFlyDialog pecFlyDialog = new PecFlyDialog();
        pecFlyDialog.show(getSupportFragmentManager(), "pec fly dialog");
    }

}