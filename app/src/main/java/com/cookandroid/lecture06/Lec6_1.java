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
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class Lec6_1 extends AppCompatActivity {

    Chronometer chrono;
    Button btnS, btnE;
    RadioGroup rdoGp;
    RadioButton rdoDate, rdoTime;
    CalendarView cal;
    TimePicker tp;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    int selectYear, selectMonth, selectDay, selectHour, selectMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lec61);

        chrono = (Chronometer) findViewById(R.id.lec6_1_chronometer);

        btnS = (Button) findViewById(R.id.lec6_1_btnS);
        btnE = (Button) findViewById(R.id.lec6_1_btnE);

        rdoGp = (RadioGroup) findViewById(R.id.lec6_1_rdoGroup);
        rdoDate = (RadioButton) findViewById(R.id.lec6_1_rdoDataset);
        rdoTime = (RadioButton) findViewById(R.id.lec6_1_rdoTimeset);

        cal = (CalendarView) findViewById(R.id.lec6_1_calenderView);
        tp = (TimePicker) findViewById(R.id.lec6_1_timePicker);

        tvYear = (TextView) findViewById(R.id.lec6_1_tvYear);
        tvMonth = (TextView) findViewById(R.id.lec6_1_tvMonth);
        tvDay = (TextView) findViewById(R.id.lec6_1_tvDay);
        tvHour = (TextView) findViewById(R.id.lec6_1_tvHour);
        tvMinute = (TextView) findViewById(R.id.lec6_1_tvMinute);

        cal.setVisibility(View.INVISIBLE);
        tp.setVisibility(View.INVISIBLE);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
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

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(selectYear));
                tvMonth.setText(Integer.toString(selectMonth));
                tvDay.setText(Integer.toString(selectDay));

                tvHour.setText(Integer.toString(tp.getCurrentHour()));
                tvMinute.setText(Integer.toString(tp.getCurrentMinute()));
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