package com.example.ticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button btn;
    Spinner s1;
    SharedPreferences sp;
    public static final String MYFIRSTPREF ="MyPref1";
    public static final String Name ="n1";
    public static final String nooft ="ticketno";
    public static final String tticket ="tickettype";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName);
        e2=findViewById(R.id.editTextTextPersonName2);
        s1=findViewById(R.id.spinner);
        btn = findViewById(R.id.button);
        sp = getSharedPreferences(MYFIRSTPREF, Context.MODE_PRIVATE);
        populate_data();
        String name = sp.getString(Name,null);
        if(name!=null){
            Intent i =new Intent(MainActivity.this,MainActivity2.class);
            startActivity(i);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed = sp.edit();
                ed.putString(Name,e1.getText().toString());
                ed.putString(nooft,e2.getText().toString());
                ed.putString(tticket,s1.getSelectedItem().toString());
                ed.apply();
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void populate_data(){
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.Gallery));
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(ad);
    }

}
