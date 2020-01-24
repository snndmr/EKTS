package com.snn.ekts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EventActivity extends AppCompatActivity {

    private int event_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        event_position = getIntent().getIntExtra("Position", 0);
        init();
    }

    void init() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventActivity.this, ScannerActivity.class));
            }
        });

        TextView tvTest = findViewById(R.id.tvTest);
        tvTest.setText(MainActivity.events.get(event_position).toString());
    }

}
