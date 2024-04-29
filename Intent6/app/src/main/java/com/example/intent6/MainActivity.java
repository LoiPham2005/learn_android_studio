package com.example.intent6;

import android.content.Intent;
import android.net.Uri;
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
    EditText edtLink;
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       edtLink =findViewById(R.id.edtLink);
       btnOpen = findViewById(R.id.btnOpen);

       btnOpen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // khai báo intent ẩn mở đến ứng dụng mở link web
               Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+edtLink.getText().toString()));
               startActivity(myIntent);
           }
       });
    }
}