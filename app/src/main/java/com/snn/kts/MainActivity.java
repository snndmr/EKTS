package com.snn.kts;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    static ArrayList<Event> events = new ArrayList<>();
    private CustomEventAdapter customEventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test();
        init();
    }

    void test() {
        for (int i = 0; i < 30; i++) {
            events.add(new Event());
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
        customEventAdapter = new CustomEventAdapter(this);
        rvEvents.setAdapter(customEventAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });
        rvEvents.setLayoutManager(gridLayoutManager);
    }

    void showAddDialog() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.event_dialog);

        final Event tempEvent = new Event();

        // To find components of event dialog
        final EditText etEventName = dialog.findViewById(R.id.etEventName);
        final EditText etEventLocation = dialog.findViewById(R.id.etEventLocation);
        final EditText etEventDescription = dialog.findViewById(R.id.etEventDescription);
        final TextView tvDateStart = dialog.findViewById(R.id.tvDateStart);
        final TextView tvTimeStart = dialog.findViewById(R.id.tvTimeStart);
        final TextView tvDateEnd = dialog.findViewById(R.id.tvDateEnd);
        final TextView tvTimeEnd = dialog.findViewById(R.id.tvTimeEnd);

        // Date Section
        tvDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this);
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                        tvDateStart.setText(date);
                        tempEvent.setDateStart(date);
                        Log.e("asd", tempEvent.getDateStart());
                    }
                });
                datePickerDialog.show();
            }
        });

        tvDateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this);
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
                        tvDateEnd.setText(date);
                        tempEvent.setDateEnd(date);
                    }
                });
                datePickerDialog.show();
            }
        });

        // Time Section
        tvTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCalendar = Calendar.getInstance();

                int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
                int minute = mCalendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String time = hourOfDay + ":" + minute;
                                tvTimeStart.setText(time);
                                tempEvent.setTimeStart(time);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        tvTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCalendar = Calendar.getInstance();

                int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
                int minute = mCalendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String time = hourOfDay + ":" + minute;
                                tvTimeEnd.setText(time);
                                tempEvent.setTimeEnd(time);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        TextView tvAdd = dialog.findViewById(R.id.tvEventAdd);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etEventName.getText().length() > 0) {
                    tempEvent.setName(etEventName.getText().toString());
                    tempEvent.setLocation(etEventLocation.getText().toString());
                    tempEvent.setDescription(etEventDescription.getText().toString());
                    tempEvent.setImage(R.drawable.test_event);

                    MainActivity.events.add(0, tempEvent);
                    customEventAdapter.notifyItemRangeChanged(0, events.size());
                    dialog.dismiss();
                } else {
                    Snackbar.make(findViewById(R.id.coordinatorLayoutMain),
                            "Etkinlik adı boş bırakılamaz!", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }
}
