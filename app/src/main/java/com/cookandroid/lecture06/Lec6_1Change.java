package com.cookandroid.lecture06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class Lec6_1Change extends AppCompatActivity {

    Chronometer chrono;
    RadioGroup rdoGp;
    RadioButton rdoDate, rdoTime;
    CalendarView cal;
    TimePicker tp;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    int selectYear, selectMonth, selectDay, selectHour, selectMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lec61_change);

        chrono = (Chronometer) findViewById(R.id.lec6_1_change_chronometer);

        rdoGp = (RadioGroup) findViewById(R.id.lec6_1_change_rdoGroup);
        rdoDate = (RadioButton) findViewById(R.id.lec6_1_change_rdoDataset);
        rdoTime = (RadioButton) findViewById(R.id.lec6_1_change_rdoTimeset);

        cal = (CalendarView) findViewById(R.id.lec6_1_change_calenderView);
        tp = (TimePicker) findViewById(R.id.lec6_1_change_timePicker);

        tvYear = (TextView) findViewById(R.id.lec6_1_change_tvYear);
        tvMonth = (TextView) findViewById(R.id.lec6_1_change_tvMonth);
        tvDay = (TextView) findViewById(R.id.lec6_1_change_tvDay);
        tvHour = (TextView) findViewById(R.id.lec6_1_change_tvHour);
        tvMinute = (TextView) findViewById(R.id.lec6_1_change_tvMinute);

        cal.setVisibility(View.INVISIBLE);
        tp.setVisibility(View.INVISIBLE);

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);

                rdoGp.setVisibility(View.VISIBLE);
            }
        });

        rdoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.VISIBLE);
                tp.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal.setVisibility(View.INVISIBLE);
                tp.setVisibility(View.VISIBLE);
            }
        });

        tvYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvHour.setText(Integer.toString(tp.getCurrentHour()));
                tvMinute.setText(Integer.toString(tp.getCurrentMinute()));

                rdoGp.setVisibility(View.INVISIBLE);
                cal.setVisibility(View.INVISIBLE);
                tp.setVisibility(View.INVISIBLE);
            }
        });

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectYear = i;
                selectMonth = i1 + 1;
                selectDay = i2;
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                selectHour = i;
            }
        });
    }
}