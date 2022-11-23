package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText temp,bp;
    int e1,e2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp=findViewById(R.id.editTextTextPersonName);
        bp=findViewById(R.id.editTextTextPersonName2);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(View view){
        e1 = Integer.parseInt(temp.getText().toString());
        e2 = Integer.parseInt(bp.getText().toString());
        String msg;
        int notification = 100;
        if((e1<=98.6)&&(e2>=60&&e2<=120)){
            msg="Your vitals are fine";
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG);
        }
        else{
            msg="You need to see the doctor !";
            String CHANNEL_ID="CSE_660";
            String CHANNEL_NAME="CSE";
            int importance= NotificationManager.IMPORTANCE_HIGH;


            NotificationChannel nc = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,importance);
            NotificationManager nm =  getSystemService(NotificationManager.class);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
            nm.createNotificationChannel(nc);


            Intent i = new Intent(this,MainActivity2.class);
            i.putExtra("Message",msg);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pd = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);


            NotificationCompat.Builder bu = new NotificationCompat.Builder(this,CHANNEL_ID);
            bu.setSmallIcon(R.drawable.ic_stat_name);
            bu.setContentIntent(pd);
            bu.setContentTitle("Health Status Notification");
            bu.setContentText("Temperature Details: "+e1+"\tBP details: "+e2);
//            notificationManager.notify(notification, bu.build());
            nm.notify(notification,bu.build());
        }
    }
}