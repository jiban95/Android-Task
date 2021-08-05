package com.example.calendertask;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calendertask.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    Calendar calendar;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.dobEditTxt.setOnClickListener(this);

        calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 9);
        calendar.set(Calendar.YEAR, 2012);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.YEAR, 1);
    }

    private void showDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog);
        calendarView = bottomSheetDialog.findViewById(R.id.calendarView);
        bottomSheetDialog.show();
        calendarView.setOnDateChangeListener((calendarView, i, i1, i2) -> {
            String date = "" + i2 + "-" + (i1 + 1) + "-" + i;
            binding.dobEditTxt.setText(date);
            bottomSheetDialog.dismiss();
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dobEditTxt: {
                showDialog();
            }
        }
    }
}