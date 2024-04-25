package com.example.linearlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // khai báo các biến giao diện
    EditText edtF, edtC;
    Button btnFC, btnCF, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    // ánh xạ ID
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnCF = findViewById(R.id.btnCF);
        btnFC = findViewById(R.id.btnFC);
        btnClear = findViewById(R.id.btnClear);

        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = Integer.parseInt(edtC.getText().toString());
                Double F = c*1.8+32;
                edtF.setText(F+"");


            }
        });

        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int f = Integer.parseInt(edtF.getText().toString());
                Double C = (f-32)/1.8;
                edtC.setText(C+"");


            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtC.setText("");
                edtF.setText("");
            }
        });

    }
}