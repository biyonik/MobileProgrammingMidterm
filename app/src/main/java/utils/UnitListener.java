package utils;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import models.UnitModel;
import services.UnitConverter;

public class UnitListener implements AdapterView.OnItemSelectedListener {
    private EditText input;
    private TextView output;
    private Context context;

    public UnitListener(EditText input, TextView output, Context context) {
        this.input = input;
        this.output = output;
        this.context = context;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        UnitModel unitModel = (UnitModel) parent.getItemAtPosition(position);
        try {
            Editable in = input.getText();
            if (in.length() == 0) {
                Toast.makeText(context, "Lütfen bir sayı giriniz.", Toast.LENGTH_SHORT).show();
                return;
            }

            Double result = UnitConverter.convert(
                    String.valueOf(this.input.getText()),
                    unitModel.getUnitEnum()
            );

            this.output.setText("Sonuç: "+ result.toString());
        } catch (NumberFormatException e) {
            Log.e("UnitListener", "onItemSelected: ", e);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
