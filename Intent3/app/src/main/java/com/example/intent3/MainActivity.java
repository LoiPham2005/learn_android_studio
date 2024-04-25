package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edta, edtkq;
    Button btnrequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.edtA);
        edtkq = findViewById(R.id.edtKQ);
        btnrequest = findViewById(R.id.btnRequest);
        btnrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                // đưa dữ liệu và intent
                int a = Integer.parseInt(edta.getText().toString());
                myintent.putExtra("soa",a);
                startActivityForResult(myintent,99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99 && resultCode ==33){
            int kq = data.getIntExtra("kq" ,0);
            edtkq.setText("Giá trị gốc la: "+kq);
        }
        if(requestCode==99 && resultCode==34){
            int kq = data.getIntExtra("kq",0);
            edtkq.setText("Giá trị BD la: "+kq);
        }
    }
}