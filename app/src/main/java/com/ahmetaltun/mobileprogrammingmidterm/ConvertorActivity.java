package com.ahmetaltun.mobileprogrammingmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.ahmetaltun.mobileprogrammingmidterm.databinding.ActivityConvertorBinding;

import java.util.ArrayList;

import builder.RadixModelBuilder;
import builder.UnitModelBuilder;
import models.RadixModel;
import models.UnitModel;
import utils.HeatListener;
import utils.RadixListener;
import utils.UnitListener;

public class ConvertorActivity extends AppCompatActivity {
    ActivityConvertorBinding binding;
    private ArrayList<RadixModel> radixList = RadixModelBuilder.buildList();
    private ArrayList<UnitModel> unitList = UnitModelBuilder.buildList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConvertorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initSpinner();
        initListeners();
    }

    private void initSpinner() {
        ArrayAdapter<RadixModel> radixSpinnerAdapter = new ArrayAdapter<RadixModel>(this, android.R.layout.simple_spinner_item, radixList);
        radixSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnRadix.setAdapter(radixSpinnerAdapter);

        ArrayAdapter<UnitModel> unitSpinnerAdapter = new ArrayAdapter<UnitModel>(this, android.R.layout.simple_spinner_item, unitList);
        unitSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnUnit.setAdapter(unitSpinnerAdapter);
    }

    private void initListeners() {
        binding.spnRadix.setOnItemSelectedListener(
                new RadixListener(
                        binding.edtDecimalInput,
                        binding.tvRadixResult,
                        this
                )
        );

        binding.spnUnit.setOnItemSelectedListener(
                new UnitListener(
                        binding.edtMegabyteInput,
                        binding.tbUnitResult,
                        this
                )
        );

        binding.rdbFahrenhayt.setOnClickListener(
                new HeatListener(
                        binding.edtCelciusInput,
                        binding.tvHeatResult,
                        this,
                        "F"
                )
        );

        binding.rdbKelvin.setOnClickListener(
                new HeatListener(
                        binding.edtCelciusInput,
                        binding.tvHeatResult,
                        this,
                        "K"
                )
        );
    }
}