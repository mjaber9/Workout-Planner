package com.example.workoutplanner;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.prefs.Preferences;

public class DumbbellPressDialog extends AppCompatDialogFragment {

    private EditText editTextReps;
    private EditText editTextSets;
    private Spinner spinnerDays;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view  = inflater.inflate(R.layout.exercise_dialog_layout, null);
        builder.setView(view)
                .setTitle("Dumbbell Press")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        chooseNext();
                        if(spinnerDays.getSelectedItem().toString().equalsIgnoreCase("Sunday")) {
                            String editText = "Dumbbell Press: " + editTextReps.getText().toString() + " repetitions for " +
                                    editTextSets.getText().toString() + " sets" ;
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("sunday", editText);
                            editor.apply();
                        }
                        if(spinnerDays.getSelectedItem().toString().equalsIgnoreCase("Monday")) {
                            String editText = "Dumbbell Press: " + editTextReps.getText().toString() + " repetitions for " +
                                    editTextSets.getText().toString() + " sets" ;
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("monday", editText);
                            editor.apply();
                        }
                        if(spinnerDays.getSelectedItem().toString().equalsIgnoreCase("Tuesday")) {
                            String editText = "Dumbbell Press: " + editTextReps.getText().toString() + " repetitions for " +
                                    editTextSets.getText().toString() + " sets" ;
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("tuesday", editText);
                            editor.apply();
                        }
                        if(spinnerDays.getSelectedItem().toString().equalsIgnoreCase("Wednesday")) {
                            String editText = "Dumbbell Press: " + editTextReps.getText().toString() + " repetitions for " +
                                    editTextSets.getText().toString() + " sets" ;
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("wednesday", editText);
                            editor.apply();
                        }
                        if(spinnerDays.getSelectedItem().toString().equalsIgnoreCase("Thursday")) {
                            String editText = "Dumbbell Press: " + editTextReps.getText().toString() + " repetitions for " +
                                    editTextSets.getText().toString() + " sets" ;
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("thursday", editText);
                            editor.apply();
                        }
                        if(spinnerDays.getSelectedItem().toString().equalsIgnoreCase("Friday")) {
                            String editText = "Dumbbell Press: " + editTextReps.getText().toString() + " repetitions for " +
                                    editTextSets.getText().toString() + " sets" ;
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("friday", editText);
                            editor.apply();
                        }
                        if(spinnerDays.getSelectedItem().toString().equalsIgnoreCase("Saturday")) {
                            String editText = "Dumbbell Press: " + editTextReps.getText().toString() + " repetitions for " +
                                    editTextSets.getText().toString() + " sets" ;
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("saturday", editText);
                            editor.apply();
                        }
                    }
                });
        editTextReps = view.findViewById(R.id.reps);
        editTextSets = view.findViewById(R.id.sets);

        spinnerDays = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.DaySelectorDialog));
        spinnerDays.setAdapter(adapter);
        return builder.create();
    }

    private void chooseNext() {
        chooseNextDialog chooseNext = new chooseNextDialog();
        chooseNext.show(getParentFragmentManager(), "choose next");
    }

}
