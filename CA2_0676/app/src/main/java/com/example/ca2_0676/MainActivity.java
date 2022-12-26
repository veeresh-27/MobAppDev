package com.example.ca2_0676;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    database db;
    EditText id,name,from,des,eid;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new database(getApplicationContext(),"flight",null,1);
        id = findViewById(R.id.editTextTextPersonName2);
        name = findViewById(R.id.editTextTextPersonName);
        from = findViewById(R.id.editTextTextPersonName3);
        des = findViewById(R.id.editTextTextPersonName4);
        eid = findViewById(R.id.editTextTextPersonName6);
    }
    public void setmethod(View v)
    {
        String id1 = id.getText().toString();
        String name1 = name.getText().toString();
        String from1 = from.getText().toString();
        String to1 = des.getText().toString();
        if(id1==" " && name1==" " && from1==" ")
        {
            Toast.makeText(this, "Input appropriate Values", Toast.LENGTH_SHORT).show();
        }
        else
        {
            db.insertrow(id1,name1,from1,to1);
            Toast.makeText(this, "Created Succesfully", Toast.LENGTH_SHORT).show();
        }
    }
    public void getmethod(View v)
    {
        String data = db.display();
        Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
    }
    public void deleteid(View v){
        String delid =  eid.getText().toString();
        db.remove(delid);
        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
    }
    public void updateid(View v){
        String newid =  eid.getText().toString();
        String oldid= id.getText().toString();
        db.updateid(oldid,newid);
        Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
    }
}
