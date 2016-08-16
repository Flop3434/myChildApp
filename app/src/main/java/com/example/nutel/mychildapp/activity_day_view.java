package com.example.nutel.mychildapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class activity_day_view extends AppCompatActivity {

    ImageButton closetimagebutton;
    ImageButton alertimagebutton;
    ImageButton eventimagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_day_view);

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
