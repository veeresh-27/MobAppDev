package com.example.sqldemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table student(sid varchar(20),sname varchar(25))");
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){

    }
    void insertrow(String id,String name)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sid",id);
        cv.put("sname",name);
        sq.insert("student",null,cv);
        sq.close();
    }
    String display(){
        String result = "";
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from student", null);
        while(c.moveToNext())
        {
            String id = c.getString(0);
            String name = c.getString(1);
            result = result + "Student id: "+id+"\t"+"Student name: "+name+"\n";
        }
        sq.close();
        return result;
    }
    void remove(String id){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("delete from student where sid="+"'"+id+"'");
    }
}
