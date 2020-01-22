package com.snn.kts;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static ArrayList<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test();
        init();
    }

    void test() {
        MainActivity.events = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            events.add(new Event(R.drawable.test_event, "Etkinlik " + (i + 1),
                    String.valueOf(i), "Etkinlik " + (i + 1) + "'nin tanımı."));
        }
    }

    void init() {
        FloatingActionButton fabEventAdd = findViewById(R.id.fabEventAdd);

        fabEventAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddDialog();
            }
        });

        RecyclerView rvEvents = findViewById(R.id.rvEvents);
        rvEvents.setAdapter(new CustomEventAdapter(this, events));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return Integer.valueOf(events.get(position).getDate()) < 1 ? 2 : 1;
            }
        });
        rvEvents.setLayoutManager(gridLayoutManager);
    }

    void showAddDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.event_dialog);

        TextView tvAdd = dialog.findViewById(R.id.tvEventAdd);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
