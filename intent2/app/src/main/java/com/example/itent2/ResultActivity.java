package com.example.itent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class ResultActivity extends AppCompatActivity {
    TextView txtNghiem;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        txtNghiem = findViewById(R.id.txtNghiem);
        btnBack = findViewById(R.id.btnBack);
        // nhập intent
        Intent myintent = getIntent();
        // lấy Bundle khỏi intent
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        // lấy dữ liệu khỏi bundle
        int a = mybundle.getInt("soa");
        int b = mybundle.getInt("sob");
        // tiến hành giải phương trình bậc nhất
        String nghiem ="";
        if(a==0 && b==0){
            nghiem="PT vố số nghiệm";
        }else if(a==0 && b!=0){
            nghiem ="PT vố nghiệm ";
        }else{
            nghiem ="Nghiệm PT = "+(-1.0)*b/a;
        }
        txtNghiem.setText(nghiem);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}