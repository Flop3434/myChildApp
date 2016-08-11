package com.example.nutel.mychildapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_day_view extends AppCompatActivity {

    ImageButton closetimagebutton;
    ImageButton alertimagebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_day_view);

        closetimagebutton = (ImageButton) findViewById(R.id.closetButton);
        alertimagebutton = (ImageButton) findViewById(R.id.alertButton);

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


    }
}
