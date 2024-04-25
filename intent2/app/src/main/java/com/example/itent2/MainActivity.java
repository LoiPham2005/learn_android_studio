package com.example.itent2;

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

public class MainActivity extends AppCompatActivity {
    Button btnKetQua;
    EditText edtA, edtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB =findViewById(R.id.edtB);
        btnKetQua = findViewById(R.id.btnKQ);

        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                // đóng gói dữ liệu vào bundle
                //dữ liệu a và b được đóng gói vào một Bundle. Bundle là một cấu trúc dữ liệu được sử dụng để chuyển dữ liệu giữa các thành phần của ứng dụng.
                Bundle mybuBundle = new Bundle();
                // đưa dữ liệu vào bundle
                mybuBundle.putInt("soa",a);
                mybuBundle.putInt("sob",b);

                // đưa bundle vào Intent
                myintent.putExtra("mypackage", mybuBundle);
                // khởi động
                startActivity(myintent);
            }
        });
    }
}