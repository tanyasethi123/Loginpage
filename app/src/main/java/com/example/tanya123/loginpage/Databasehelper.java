package com.example.tanya123.loginpage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
public class Databasehelper extends SQLiteOpenHelper {
    private static final String DB_Name = "login";
    private static final int DB_Version = 2;

    Databasehelper(Context context) {
        super(context, DB_Name,null , DB_Version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DETAILS(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "FULLNAME TEXT,"
                + "USERNAME TEXT,"
                + "EMAIL TEXT,"
                + "PASSWORD TEXT);");
        ContentValues d = new ContentValues();
        d.put("FULLNAME", "Tanya Sethi");
        d.put("USERNAME", "tanya123");
        d.put("EMAIL", "sethi.tanya123@gmail.com");
        d.put("PASSWORD", "123tanya");

        db.insert("DETAILS", null, d);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 2)
            onCreate(db);
    }

    public  void insertvalues(SQLiteDatabase db, String name, String username, String email, String password) {
        ContentValues c = new ContentValues();
        c.put("FULLNAME", name);
        c.put("USERNAME", username);
        c.put("EMAIL", email);
        c.put("PASSWORD", password);
        db.insert("DETAILS", null, c);
    }
}