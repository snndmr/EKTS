package com.snn.ekts;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

        Calendar calendar = Calendar.getInstance();
        String date = calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
        String time = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);

        final Event tempEvent = new Event();
        tempEvent.setDateEnd(date);
        tempEvent.setDateStart(date);
        tempEvent.setTimeEnd(time);
        tempEvent.setTimeStart(time);

        // To find components of event dialog
        final EditText etEventName = dialog.findViewById(R.id.etEventName);
        final EditText etEventLocation = dialog.findViewById(R.id.etEventLocation);
        final EditText etEventDescription = dialog.findViewById(R.id.etEventDescription);
        final TextView tvDateStart = dialog.findViewById(R.id.tvDateStart);
        final TextView tvDateEnd = dialog.findViewById(R.id.tvDateEnd);
        final TextView tvTimeStart = dialog.findViewById(R.id.tvTimeStart);
        final TextView tvTimeEnd = dialog.findViewById(R.id.tvTimeEnd);

        tvDateStart.setText(date);
        tvDateEnd.setText(date);
        tvTimeStart.setText(time);
        tvTimeEnd.setText(time);

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
                    if (isDateValid(tempEvent.getDateStart(), tempEvent.getDateEnd(),
                            tempEvent.getTimeStart(), tempEvent.getTimeEnd())) {
                        tempEvent.setName(etEventName.getText().toString());
                        tempEvent.setLocation(etEventLocation.getText().toString());
                        tempEvent.setDescription(etEventDescription.getText().toString());
                        tempEvent.setImage(R.drawable.test_event);

                        MainActivity.events.add(0, tempEvent);
                        customEventAdapter.notifyItemInserted(0);
                        dialog.dismiss();
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Tarihleri doğru giriniz!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this,
                            "Etkinlik adı boş bırakılamaz!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    @SuppressLint("SimpleDateFormat")
    boolean isDateValid(String dateStart, String dateEnd, String timeStart, String timeEnd) {
        boolean flag = false;

        try {
            Date _dateStart = new SimpleDateFormat("dd/MM/yyyy").parse(dateStart);
            Date _dateEnd = new SimpleDateFormat("dd/MM/yyyy").parse(dateEnd);
            Date _timeStart = new SimpleDateFormat("HH:mm").parse(timeStart);
            Date _timeEnd = new SimpleDateFormat("HH:mm").parse(timeEnd);

            if (_dateEnd != null && _dateEnd.equals(_dateStart)) {
                if (_timeEnd != null && _timeEnd.after(_timeStart)) {
                    flag = true;
                }
            } else if (_dateEnd != null && _dateEnd.after(_dateStart)) {
                flag = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
