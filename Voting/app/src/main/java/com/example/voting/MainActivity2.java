package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = findViewById(R.id.textView3);
        Intent i = getIntent();
        int ag = i.getIntExtra("age",0);
        String n = i.getStringExtra("name");
        String a = i.getStringExtra("aadhar");
        if(ag >= 1)
        {
            t.setText(n+" having Aadhar Number "+a+" is Eligible to Vote");
        }
        else
        {
            t.setText(n+" having Aadhar Number "+a+" is not Eligible to Vote");
        }
    }
}