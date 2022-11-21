package com.example.supermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView textView_0001;
    RatingBar ratingBar_0001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView_0001=findViewById(R.id.textView2);
        ratingBar_0001=findViewById(R.id.ratingBar);

        Intent intent=getIntent();
        Integer amount= intent.getIntExtra("amount",0);
        textView_0001.setText(amount.toString());
    }
    public void rating_0001(View v){

        Float rating_001=ratingBar_0001.getRating();
        Toast.makeText(getApplicationContext(), "Rating: "+String.valueOf(rating_001), Toast.LENGTH_SHORT).show();

    }
}
