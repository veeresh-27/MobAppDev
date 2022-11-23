package com.example.voting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,aadhar,age;
    Button move;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextTextPersonName);
        aadhar = findViewById(R.id.editTextTextPersonName2);
        age = findViewById(R.id.editTextTextPersonName3);
        move = findViewById(R.id.button);
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = name.getText().toString();
                String a = aadhar.getText().toString();
                String ag = age.getText().toString();
                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("name",n);
                i.putExtra("age",Integer.parseInt(ag));
                i.putExtra("aadhar",a);
                startActivity(i);
            }
        });
    }
}