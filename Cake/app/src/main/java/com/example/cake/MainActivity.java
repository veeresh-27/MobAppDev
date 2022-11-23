package com.example.cake;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    CheckBox marble_215, chocolate_215, velvet_215, cookie_215, ice_215, cheese_215;
    EditText name_215, msg_215, contact_215;
    DatePicker date_215;
    Button btn_215;
    String day;
    int i = 100;

    public static final String capitalize(String str)
    {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public void hide(){
        name_215.setText("");
        name_215.requestFocus();
        msg_215.setText("");
        contact_215.setText("");
        marble_215.setChecked(false);
        chocolate_215.setChecked(false);
        velvet_215.setChecked(false);
        cookie_215.setChecked(false);
        ice_215.setChecked(false);
        cheese_215.setChecked(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        marble_215 = findViewById(R.id.marble_215);
        chocolate_215 = findViewById(R.id.chocolate_215);
        velvet_215 = findViewById(R.id.velvet_215);
        cookie_215 = findViewById(R.id.cookie_215);
        ice_215 = findViewById(R.id.ice_215);
        cheese_215 = findViewById(R.id.cheese_215);
        btn_215 = findViewById(R.id.btn_215);
        name_215 = findViewById(R.id.name_215);
        date_215 = findViewById(R.id.date_215);
        msg_215 = findViewById(R.id.msg_215);
        contact_215 = findViewById(R.id.contact_215);

        date_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd_215 = new DatePickerDialog(MainActivity.this, MainActivity.this, Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

                dpd_215.getDatePicker().setMinDate(System.currentTimeMillis());
                dpd_215.show();
            }
        });

        btn_215.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int total = 0;
                    StringBuilder s_215 = new StringBuilder();
                    s_215.append("BOOKING ID : " + (i++) + "\nNAME : " + capitalize(name_215.getText().toString()) + "\nCONTACT : "
                            + contact_215.getText().toString() + "\n\nORDER SUMMARY : \n");
                    if(marble_215.isChecked()) {
                        s_215.append("Marble Cake \n"); total += 300;
                    }
                    if(chocolate_215.isChecked()) {
                        s_215.append("Chocolate Cake\n"); total += 1100;
                    }
                    if(velvet_215.isChecked()) {
                        s_215.append("Red Velvet Cake\n"); total += 1375;
                    }
                    if(cookie_215.isChecked()) {
                        s_215.append("Cookie Cake\n"); total += 800;
                    }
                    if(ice_215.isChecked()) {
                        s_215.append("Ice Cream Cake\n"); total += 700;
                    }
                    if(cheese_215.isChecked()) {
                        s_215.append("Cheesecake\n"); total += 1000;
                    }
                    s_215.append("\nMESSAGE : " + msg_215.getText().toString() + "\nPRICE : RS. " + total + "\nDATE OF DELIVERY  : " + day);

                    if(name_215.getText().toString() == null || msg_215.getText().toString() == null || total == 0 || day == null || contact_215.getText().toString()== null || contact_215.getText().toString().length() > 10  || contact_215.getText().toString().length() < 10 || (!marble_215.isChecked() &&
                            !chocolate_215.isChecked() && !velvet_215.isChecked() && !cookie_215.isChecked() && !ice_215.isChecked()
                            && !cheese_215.isChecked())){
                        Toast.makeText(MainActivity.this, "Missing fields or incorrect input. Please fill in all the slots correctly", Toast.LENGTH_SHORT).show();
                        name_215.requestFocus();
                    }
                    else{
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("booking_confirmation", s_215.toString());
                        startActivity(intent);
                        for(int i = 0; i < 50000; i++){
                            //Delay
                        }
                        hide();
                    }
                }
                catch(Exception ex){
                    Toast.makeText(MainActivity.this, "Invalid Order Placed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        day = (month + 1) + "/" + date + "/" + year;
    }
}
