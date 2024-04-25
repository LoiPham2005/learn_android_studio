package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    EditText edtAA;
    Button btngoc, btnBP;
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        edtAA = findViewById(R.id.edtAA);
        btngoc = findViewById(R.id.btnGoc);
        btnBP = findViewById(R.id.btnBP);
        // nhận intent
        myintent = getIntent();
        // lấy dữ liệu ra khỏi intent
        int a = myintent.getIntExtra("soa",0);
        edtAA.setText(a+"");
        btngoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq",a);
                setResult(33,myintent);
                finish();
            }
        });

        btnBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq", a*a);
                setResult(34, myintent);
                finish();
            }
        });
    }
}