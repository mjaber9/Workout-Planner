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

public class BicepsExercises extends AppCompatActivity {

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
        getSupportActionBar().setTitle("Bicep Exercises");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setUpListView() {
        String[] title = getResources().getStringArray(R.array.BicepExercises);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: {
                        barbellCurlDialog();
                        break;
                    }
                    case 1: {
                        hammerCurlDialog();
                        break;
                    }
                    case 2: {
                        cableCurlDialog();
                        break;
                    }
                    case 3: {
                        preacherCurlDialog();
                        break;
                    }
                    case 4: {
                        dumbbellCurlDialog();
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

            if (titleArray[i].equalsIgnoreCase("Barbell Curl")) {
                imageView.setImageResource(R.drawable.barbell_curl);
            } else if (titleArray[i].equalsIgnoreCase("Hammer Curl")) {
                imageView.setImageResource(R.drawable.hammer_curl);
            } else if (titleArray[i].equalsIgnoreCase("Bicep Cable Curl")) {
                imageView.setImageResource(R.drawable.bicep_cable_curl);
            } else if (titleArray[i].equalsIgnoreCase("EZ-Bar Preacher Curl")) {
                imageView.setImageResource(R.drawable.preacher_curl);
            } else if (titleArray[i].equalsIgnoreCase("Dumbbell Curl")) {
                imageView.setImageResource(R.drawable.dumbbell_curl);
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

    private void barbellCurlDialog() {
        BarbellCurlDialog barbellCurlDialog = new BarbellCurlDialog();
        barbellCurlDialog.show(getSupportFragmentManager(), "barbell curl dialog");
    }

    private void hammerCurlDialog() {
        HammerCurlDialog hammerCurlDialog = new HammerCurlDialog();
        hammerCurlDialog.show(getSupportFragmentManager(), "hammer curl dialog");
    }

    private void cableCurlDialog() {
        CableCurlDialog cableCurlDialog = new CableCurlDialog();
        cableCurlDialog.show(getSupportFragmentManager(), "cable curl dialog");
    }

    private void preacherCurlDialog() {
        PreacherCurlDialog preacherCurlDialog = new PreacherCurlDialog();
        preacherCurlDialog.show(getSupportFragmentManager(), "preacher curl dialog");
    }

    private void dumbbellCurlDialog() {
        DumbbellCurlDialog dumbbellCurlDialog = new DumbbellCurlDialog();
        dumbbellCurlDialog.show(getSupportFragmentManager(), "dumbbell curl dialog");
    }

}