package com.example.nutel.mychildapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class activity_day_view extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> adapter;
    String[] times = {"5am", "6am", "7am", "8am", "9am", "10am", "11 am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm",
            "9pm", "10pm", "11pm", "12am", "1am", "2am", "3am", "4am",};

    ImageButton closetimagebutton;
    ImageButton alertimagebutton;
    ImageButton eventimagebutton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_day_view);
        listView = (ListView)findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, times);
        listView.setAdapter(adapter);




        closetimagebutton = (ImageButton) findViewById(R.id.closetButton);
        alertimagebutton = (ImageButton) findViewById(R.id.alertButton);
        eventimagebutton = (ImageButton) findViewById(R.id.eventButton); // TODO: Change "setting_gear.png" to an event activity icon

        closetimagebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), closet_display.class));
            }

        });

        alertimagebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), alert_display.class));
            }
        });

        eventimagebutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), event_display.class));
            }
        });


    }
}
