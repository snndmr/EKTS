package com.snn.kts;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    protected void init() {
        FloatingActionButton fabEventAdd = findViewById(R.id.fabEventAdd);

        fabEventAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.coorLayoutMain),
                        "Floating Button Clicked!", Snackbar.LENGTH_SHORT).show();
            }
        });

        RecyclerView rvEvents = findViewById(R.id.rvEvents);
        rvEvents.setAdapter(new CustomAdapter(this));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });
        rvEvents.setLayoutManager(gridLayoutManager);
    }
}
