package com.example.ca1_0676;
import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ListView activityList0676;
    String activitiesArray0676[] = {
            "Swimming"," Running", "Badminton","Tennis",
    };
    ArrayAdapter arrayAdapter0676;
    TextView selectedTimeTV0676;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityList0676 = findViewById(R.id.listView);
        selectedTimeTV0676 = findViewById(R.id.idTVSelectedTime);

          arrayAdapter0676      = new ArrayAdapter(this, android.R.layout.simple_list_item_1, activitiesArray0676);
        activityList0676.setAdapter(arrayAdapter0676);
        activityList0676.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Calendar c0676 = Calendar.getInstance();
                // on below line we are getting our hour, minute.
                int hour0676 = c0676.get(Calendar.HOUR_OF_DAY);
                int minute0676 = c0676.get(Calendar.MINUTE);

                // on below line we are initializing our Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // on below line we are setting selected time
                                // in our text view.
                                selectedTimeTV0676.setText("Appoint Fixed\n"+activitiesArray0676[i]+"\n"+"Friday 23rd Oct 2022"+"\n"+hourOfDay + ":" + minute);
                            }
                        }, hour0676, minute0676, false);
                // at last we are calling show to
                // display our time picker dialog.
                timePickerDialog.show();
            }
        });


    }
}