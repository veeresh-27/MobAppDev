package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    TextView name1 = findViewById(R.id.name);
    TextView phone1 = findViewById(R.id.name);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name1 = findViewById(R.id.name);
        phone1 = findViewById(R.id.name);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<String> courseSelected = (ArrayList<String>) args.getSerializable("ARRAYLIST");

        name1.setText(name);
        phone1.setText(phone);
    }
}