package utils;

import android.content.Context;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import services.HeatConverterManager;

public class HeatListener implements View.OnClickListener {
    private EditText input;
    private TextView output;
    private Context context;
    private String type;

    public HeatListener(EditText input, TextView output, Context context, String type) {
        this.input = input;
        this.output = output;
        this.context = context;
        this.type = type;
    }

    @Override
    public void onClick(View v) {
        try {
            Editable in = input.getText();
            if (in.length() == 0) {
                Toast.makeText(context, "Lütfen bir sayı giriniz.", Toast.LENGTH_SHORT).show();
                return;
            }

            String convertResult = "";
            switch (this.type) {
                case "F":
                    convertResult = HeatConverterManager.convertToCelciusToFahrenheit(String.valueOf(this.input.getText()));
                    break;
                case "K":
                    convertResult = HeatConverterManager.convertToCelciusToKelvin(String.valueOf(this.input.getText()));
                    break;
                default:
                    break;
            }

            this.output.setText("Sonuç: "+ convertResult);

        } catch (Exception e) {
            Log.e("HeatListener", "Error: " + e.getMessage());
        }
    }
}
