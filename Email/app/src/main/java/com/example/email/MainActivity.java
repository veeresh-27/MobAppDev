package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText addr, sub, msg;

    Button send;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        addr=findViewById(R.id.editTextTextEmailAddress);
        msg = findViewById(R.id.msgid);
        sub=findViewById(R.id.editTextTextPersonName);

        send=findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                String toadd=addr.getText().toString();

                String subject=sub.getText().toString();

                String message=msg.getText().toString();
                Intent i=new Intent(Intent.ACTION_SEND);

                i.putExtra(Intent.EXTRA_EMAIL, new String[]{toadd});
                i.putExtra(Intent.EXTRA_SUBJECT,subject);
                i.putExtra(Intent.EXTRA_TEXT,message);
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i,"Choose an Email Client"));
            }
        });
    }
}