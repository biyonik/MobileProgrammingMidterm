package com.ahmetaltun.mobileprogrammingmidterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ahmetaltun.mobileprogrammingmidterm.databinding.ActivitySendSmsBinding;

public class SendSmsActivity extends AppCompatActivity {
    ActivitySendSmsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendSmsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initEvents();

    }

    private void initEvents() {
        binding.btnSendSMS.setOnClickListener(v -> {
            String phoneNumber = binding.edtPhoneNumber.getText().toString();
            String message = binding.edtMessage.getText().toString();
            sendSms(phoneNumber, message);
        });
    }

    private void sendSms(String phoneNumber, String message) {
        if (phoneNumber == null || phoneNumber.length() == 0 ||
                message == null || message.length() == 0) {
            Toast.makeText(this, "Telefon numarası veya mesaj boş olamaz!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
                    != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]
                                {android.Manifest.permission.SEND_SMS},
                        1);
            }

            android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null ,null);
            Toast.makeText(this, "Mesaj gönderildi!", Toast.LENGTH_SHORT).show();
        } catch (Exception e ) {
            Toast.makeText(this, "Mesaj gönderilemedi!", Toast.LENGTH_SHORT).show();
            Log.e("SendSmsActivity", e.getMessage());
        }
    }
}