package com.example.intent_filter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    WebView myweb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myweb =findViewById(R.id.myWeb);
        Intent myItent = getIntent();
        Uri myLink = myItent.getData();
        try {
            myweb.loadUrl(myLink.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}