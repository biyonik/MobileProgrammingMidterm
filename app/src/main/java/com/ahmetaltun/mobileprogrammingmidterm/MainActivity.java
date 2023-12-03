package com.ahmetaltun.mobileprogrammingmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmetaltun.mobileprogrammingmidterm.databinding.ActivityMainBinding;

import utils.GoToActivityListener;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListeners();
    }

    private void initListeners() {
        binding.btnGoToConvertor.setOnClickListener(new GoToActivityListener(this, ConvertorActivity.class));
        binding.btnGoToRandomProgress.setOnClickListener(new GoToActivityListener(this, RandomProgressBarActivity.class));
        binding.btnGoToSms.setOnClickListener(new GoToActivityListener(this, SendSmsActivity.class));
    }
}