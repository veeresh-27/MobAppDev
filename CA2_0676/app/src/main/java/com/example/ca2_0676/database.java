package com.example.ca2_0676;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public static final String col = "ID";
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table flight(fid varchar(20),fname varchar(25),from1 varchar(30),to1 varchar(30))");
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){

    }
    void insertrow(String id, String name, String frm,String des)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fid",id);
        cv.put("fname",name);
        cv.put("from1",frm);
        cv.put("to1",des);
        sq.insert("flight",null,cv);
        sq.close();
    }
    String display(){
        String result = "";
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from flight", null);
        while(c.moveToNext())
        {
            String id = c.getString(0);
            String name = c.getString(1);
            String frm = c.getString(2);
            String des = c.getString(3);
            result = result + "id: "+id+"\t"+"name: "+name+"\t"+"from: "+frm+"\t"+"to: "+des+"\n";
        }
        sq.close();
        return result;
    }
    void remove(String id){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("delete from flight where fid="+"'"+id+"'");
    }
    void updateid(String oid,String nid){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("update from flight where bid="+"'"+oid+"'"+"where bid="+"'"+nid+"'");

    }
}