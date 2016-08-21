package com.example.nutel.mychildapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class closet_display extends AppCompatActivity {

    public Button buttonCancel,
            buttonDecDiapers, buttonDecWipes, buttonDecOintments,
            buttonIncDiapers, buttonIncWipes, buttonIncOintments;
    public EditText textDiapers, textWipes, textOintments;
    public int numDiapers, numWipes, numOintments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closet_display);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create text fields
        textDiapers = (EditText)findViewById(R.id.text_diapers);
        textWipes = (EditText)findViewById(R.id.text_wipes);
        textOintments = (EditText)findViewById(R.id.text_ointments);

        // TODO: Read values from local database
        numDiapers = 0;
        numWipes = 0;
        numOintments = 0;

        textDiapers.setText(Integer.toString(numDiapers), TextView.BufferType.EDITABLE);
        textWipes.setText(Integer.toString(numWipes), TextView.BufferType.EDITABLE);
        textOintments.setText(Integer.toString(numOintments), TextView.BufferType.EDITABLE);

        // Create subtract/add buttons
        buttonDecDiapers = (Button)findViewById(R.id.button_dec_diapers);
        buttonDecWipes = (Button)findViewById(R.id.button_dec_wipes);
        buttonDecOintments = (Button)findViewById(R.id.button_dec_ointments);
        buttonIncDiapers = (Button)findViewById(R.id.button_inc_diapers);
        buttonIncWipes = (Button)findViewById(R.id.button_inc_wipes);
        buttonIncOintments = (Button)findViewById(R.id.button_inc_ointments);

        buttonDecDiapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numDiapers > 0) {
                    numDiapers--;
                    textDiapers.setText(Integer.toString(numDiapers), TextView.BufferType.EDITABLE);
                }
            }
        });

        buttonDecWipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numWipes > 0) {
                    numWipes--;
                    textWipes.setText(Integer.toString(numWipes), TextView.BufferType.EDITABLE);
                }
            }
        });

        buttonDecOintments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOintments > 0) {
                    numOintments--;
                    textOintments.setText(Integer.toString(numOintments), TextView.BufferType.EDITABLE);
                }
            }
        });

        buttonIncDiapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numDiapers++;
                textDiapers.setText(Integer.toString(numDiapers), TextView.BufferType.EDITABLE);
            }
        });

        buttonIncWipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numWipes++;
                textWipes.setText(Integer.toString(numWipes), TextView.BufferType.EDITABLE);
            }
        });

        buttonIncOintments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOintments++;
                textOintments.setText(Integer.toString(numOintments), TextView.BufferType.EDITABLE);
            }
        });

        // Create Back button
        buttonCancel = (Button)findViewById(R.id.backButton);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(closet_display.this, activity_day_view.class));
            }
        });
    }

}

