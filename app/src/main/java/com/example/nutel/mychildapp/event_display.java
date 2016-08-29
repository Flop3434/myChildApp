package com.example.nutel.mychildapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import java.util.Calendar;

public class event_display extends AppCompatActivity {

    // Layout elements
    private static RadioGroup radioButtonGroup;
    private static RadioButton selectedRadioButton;
    private static EditText textDate, textTime, textDuration;
    private static LinearLayout layoutDuration;
    public Button buttonCancel, buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create date picker dialogue
        textDate = (EditText) findViewById((R.id.text_date));
        textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        // Create time picker dialogue
        textTime = (EditText) findViewById((R.id.text_time));
        textTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(v);
            }
        });

        // Create duration linear layout and text view
        layoutDuration = (LinearLayout) findViewById((R.id.layout_duration));
        textDuration = (EditText) findViewById((R.id.text_duration));

        // Set up the radio buttons for each event
        radioButtonGroup = (RadioGroup)findViewById(R.id.radio_group_events);
        // If "Nap" radio button is NOT selected, don't show the duration dialogue
        radioButtonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioButtonGroup.getCheckedRadioButtonId() != R.id.radioNap) {
                    layoutDuration.setVisibility(View.INVISIBLE);
                } else {
                    layoutDuration.setVisibility(View.VISIBLE);
                }
            }
        });

        // Create Back button
        buttonCancel = (Button)findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(event_display.this, activity_day_view.class));
            }
        });

        // Create Submit button
        buttonSubmit = (Button)findViewById(R.id.button_done);
        //TODO this will need to input 2 string values and a bool that will save to a local data base
        // values are str Date, str Time, and bool Event type
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(event_display.this, activity_day_view.class));
            }
        });

    }



    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    // Class for selecting the date
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int year, int day, int month) {
            textDate.setText(month + "/" + day + "/" + year);
        }
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
            textTime.setText(String.format("%02d",hourOfDay) + ":" + String.format("%02d",minute));
        }

    }

}
