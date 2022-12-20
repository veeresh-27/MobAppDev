package com.example.ticketbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView txt2;
    Button btn1;
    SharedPreferences sp;
    public static final String MYFIRSTPREF ="MyPref1";
    public static final String Name ="n1";
    public static final String nooft ="ticketno";
    public static final String tticket ="tickettype";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt2=findViewById(R.id.textView);
        btn1=findViewById(R.id.button2);
        sp=getSharedPreferences(MYFIRSTPREF, Context.MODE_PRIVATE);
        String n1 = sp.getString(Name,null);
        String ticketno = sp.getString(nooft,null);
        String tt =sp. getString(tticket,null);

        if (n1 != null||ticketno!=null||tt!=null) {
            txt2.setText("Name: "+n1+" \n"+"No.of tickets: "+ticketno+"\n"+"Ticket type: "+tt);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor ed = sp.edit();
                ed.clear();
                ed.commit();
                finish();
                Toast.makeText(MainActivity2.this, "SharedPreference data is clear", Toast.LENGTH_SHORT).show();
            }
        });



    }
}