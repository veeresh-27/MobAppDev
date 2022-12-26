package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText no,msg;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        no = findViewById(R.id.editTextTextPersonName);
        msg = findViewById(R.id.editTextTextPersonName2);
        send = findViewById(R.id.button);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = no.getText().toString();
                String msgs = msg.getText().toString();
                try{
                    SmsManager sm = SmsManager.getDefault();
                    sm.sendTextMessage(ph,null,msgs,null,null);
                    Toast.makeText(MainActivity.this, "Message sent Succesfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Message not sent", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}