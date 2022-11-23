package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt=findViewById(R.id.textView);
        onNewIntent(getIntent());
        NotificationManager nm =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(100);


    }
    @Override
    protected void onNewIntent(Intent i){

        Bundle b = i.getExtras();
        if(b!=null) {
            if (b.containsKey("Message"))
            {
                setContentView(R.layout.activity_main2);
                String mesg =b.getString("Message");
                txt.setText("Report: "+mesg);
            }
            super.onNewIntent(i);
        }
    }
}