package com.ahmetaltun.mobileprogrammingmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ahmetaltun.mobileprogrammingmidterm.databinding.ActivityRandomProgressBarBinding;

import utils.PieceChangeListener;
import services.RandomProgressBarManager;

public class RandomProgressBarActivity extends AppCompatActivity {
    ActivityRandomProgressBarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRandomProgressBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListener();
    }

    private void initListener() {
        binding.edtPiece.addTextChangedListener(
                new PieceChangeListener(
                        binding.scrollMain,
                        new RandomProgressBarManager(this, binding.scrollMain)
                )
        );
    }
}