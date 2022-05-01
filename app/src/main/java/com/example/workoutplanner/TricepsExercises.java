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

public class TricepsExercises extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Triceps Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.TricepsExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        ropePushdownDialog();
                        break;
                    }
                    case 1: {
                        tricepDipDialog();
                        break;
                    }
                    case 2: {
                        tricepExtensionDialog();
                        break;
                    }
                    case 3: {
                        skullcrushersDialog();
                        break;
                    }
                    case 4: {
                        overheadExtensionDialog();
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

            if (titleArray[i].equalsIgnoreCase("Rope Tricep Pushdown")) {
                imageView.setImageResource(R.drawable.tricep_pushdown);
            } else if (titleArray[i].equalsIgnoreCase("Tricep Dips")) {
                imageView.setImageResource(R.drawable.triceps_dips);
            } else if (titleArray[i].equalsIgnoreCase("Dumbbell Tricep Extension")) {
                imageView.setImageResource(R.drawable.dumbbell_tricep_extension);
            } else if (titleArray[i].equalsIgnoreCase("Skullcrushers")) {
                imageView.setImageResource(R.drawable.skullcrushers);
            } else if (titleArray[i].equalsIgnoreCase("Overhead Tricep Extension")) {
                imageView.setImageResource(R.drawable.overhead_tricep_extension);
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

    private void ropePushdownDialog() {
        RopePushdownDialog ropePushdownDialog = new RopePushdownDialog();
        ropePushdownDialog.show(getSupportFragmentManager(), "rope pushdown dialog");
    }

    private void tricepDipDialog() {
        TricepDipDialog tricepDipDialog = new TricepDipDialog();
        tricepDipDialog.show(getSupportFragmentManager(), "triceps dip dialog");
    }

    private void tricepExtensionDialog() {
        TricepExtensionDialog tricepExtensionDialog = new TricepExtensionDialog();
        tricepExtensionDialog.show(getSupportFragmentManager(), "triceps extension dialog");
    }

    private void skullcrushersDialog() {
        SkullcrushersDialog skullcrushersDialog = new SkullcrushersDialog();
        skullcrushersDialog.show(getSupportFragmentManager(), "skullcrushers dialog");
    }

    private void overheadExtensionDialog() {
        OverheadExtensionDialog overheadExtensionDialog = new OverheadExtensionDialog();
        overheadExtensionDialog.show(getSupportFragmentManager(), "overhead extension dialog");
    }

}