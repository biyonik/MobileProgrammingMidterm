package utils;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import services.RadixConverterManager;
import models.RadixModel;

public class RadixListener implements AdapterView.OnItemSelectedListener {
    private EditText input;
    private TextView output;
    private Context context;

    public RadixListener(EditText input, TextView output, Context context) {
        this.input = input;
        this.output = output;
        this.context = context;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        RadixModel radixModel = (RadixModel) parent.getItemAtPosition(position);
        try {
            Editable in = input.getText();
            if (in.length() == 0) {
                Toast.makeText(context, "Lütfen bir sayı giriniz.", Toast.LENGTH_SHORT).show();
                return;
            }

            String result = RadixConverterManager.convert(String.valueOf(this.input.getText()), radixModel);
            this.output.setText("Sonuç: "+ result);
        } catch (NumberFormatException e) {
            Log.e("RadixListener", "onItemSelected: ", e);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
