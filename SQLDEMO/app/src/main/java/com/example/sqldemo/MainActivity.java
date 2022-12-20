package com.example.sqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    database db;
    EditText id,name,delid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new database(getApplicationContext(),"student",null,1);
        id = findViewById(R.id.editTextTextPersonName2);
        name = findViewById(R.id.editTextTextPersonName);
        delid = findViewById(R.id.editTextTextPersonName3);

    }
    public void setmethod(View v)
    {
        String id1 = id.getText().toString();
        String name1 = name.getText().toString();
        String prevId = null;
        prevId = db.display();
        if(prevId != null){
            db.insertrow(id1,name1);
            id.setText("");
            name.setText("");
            delid.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"Id already exist.",Toast.LENGTH_SHORT);
        }

    }
    public void getmethod(View v)
    {
        String data = db.display();
        Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
    }
    public void deleteid(View v){
        String delid1 =  delid.getText().toString();
        db.remove(delid1);
    }
}