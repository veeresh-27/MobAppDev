package com.example.autocompletetext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText sname, fname;
    Button btn;
    AutoCompleteTextView loc;
    String[] locations = {"Bangalore", "Chennai", "Hyderabad", "Uttar_Pradesh"};
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sname = findViewById(R.id.editTextTextPersonName);
        fname = findViewById(R.id.editTextTextPersonName2);
        btn = findViewById(R.id.button);
        loc = findViewById(R.id.autoCompleteTextView);
        result = findViewById(R.id.textView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, locations);
        loc.setThreshold(1);
        loc.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String studname = sname.getText().toString();
                String faname = fname.getText().toString();
                String s_location = loc.getText().toString();
                result.setText("Student_Name:" + studname + "\n" + "Father_Name" + faname + "\n" + "Place" + s_location + "\n");
            }
        });
    }
}