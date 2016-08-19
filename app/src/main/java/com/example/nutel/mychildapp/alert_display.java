package com.example.nutel.mychildapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class alert_display extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    static EditText TimeText;
    Spinner alertTypeSpinner;
    public Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create time picker dialogue
        TimeText = (EditText) findViewById((R.id.text_time));
        TimeText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v);
            }
        });

        // Create the spinner
        alertTypeSpinner = (Spinner) findViewById(R.id.alertSpinner);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.alert_types, android.R.layout.simple_spinner_item);
        alertTypeSpinner.setAdapter((adapter));
        alertTypeSpinner.setOnItemSelectedListener(this);

        cancelButton = (Button)findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(alert_display.this, activity_day_view.class));
            }
        });

    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView myText = (TextView) view;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Class for selecting the time
    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }



        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
            TimeText.setText(String.format("%02d",hourOfDay) + ":" + String.format("%02d",minute));
        }

    }

}