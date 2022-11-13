package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText h, w;
    String result;
    TextView r;
    Double Height, Weight, res;
    Button BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h = findViewById(R.id.editTextTextPersonName);
        w = findViewById(R.id.editTextTextPersonName2);
        BMI = findViewById(R.id.button);
        r = findViewById(R.id.textView2);
        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Height = Double.parseDouble(h.getText().toString());
                Weight = Double.parseDouble(w.getText().toString());
                res = Weight / (Height * Height);
                if (res < 18.5) {
                    result = "Under Weight!";
                } else if (res >= 18.5 && res < 24.9) {
                    result = "Healthy!!";
                } else if (res >= 24.9 && res < 30) {
                    result = "Overweight!";
                } else if (res >= 30) {
                    result = "Suffering from Obesity";
                }
                Toast.makeText(getApplicationContext(), res.toString(), Toast.LENGTH_LONG).show();
                r.setText(result);
            }
        });
    }
}