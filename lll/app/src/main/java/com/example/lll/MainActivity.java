package com.example.lll;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText nhapA, nhapB, ketQua;
    Button cong, tru, nhan, chia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        nhapA = findViewById(R.id.edtA);
        nhapB = findViewById(R.id.edtB);
        ketQua = findViewById(R.id.edtTong);

        cong = findViewById(R.id.btnCong);
        tru = findViewById(R.id.btnTru);
        nhan = findViewById(R.id.btnNhan);
        chia = findViewById(R.id.btnChia);

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(nhapA.getText().toString());
                int b = Integer.parseInt(nhapB.getText().toString());
                int c = a + b;
                ketQua.setText(String.valueOf(c));
            }
        });

        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(nhapA.getText().toString());
                int b = Integer.parseInt(nhapB.getText().toString());
                int d =a -b;
                ketQua.setText(String.valueOf(d));
            }
        });

        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(nhapA.getText().toString());
                int b = Integer.parseInt(nhapB.getText().toString());
                int e =a*b;
                ketQua.setText(String.valueOf(e));
            }
        });

        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(nhapA.getText().toString());
                int b = Integer.parseInt(nhapB.getText().toString());
                int f =a/b;
                ketQua.setText(String.valueOf(f));
            }
        });
    }
}