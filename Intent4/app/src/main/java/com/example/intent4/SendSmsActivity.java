package com.example.intent4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SendSmsActivity extends AppCompatActivity {
    EditText edtSMS;
    ImageButton btnSMS;
    Button btnBack2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_sms);

        edtSMS = findViewById(R.id.edtSMS2);
        btnSMS = findViewById(R.id.btnSMS2);
        btnBack2 = findViewById(R.id.btnBack2);

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent2 = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto: "+edtSMS.getText().toString()));
                startActivity(myIntent2);
            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}