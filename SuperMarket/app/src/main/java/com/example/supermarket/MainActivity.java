package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    CheckBox c1_0001,c2_0001,c3_0001;
    Button b1_0001;
    int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1_0001=findViewById(R.id.checkBox);
        c2_0001=findViewById(R.id.checkBox2);
        c3_0001=findViewById(R.id.checkBox3);
        b1_0001=findViewById(R.id.button);

    }
    public void next_activity(View v){
        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("amount",total);
        startActivity(intent);
    }
    public void check_0001(View v){

        if(c1_0001.isChecked()){
            total=total+60;
        }
        if(c2_0001.isChecked()){
            total=total+40;
        }
        if(c3_0001.isChecked()){
            total=total+120;
        }
    }
}
