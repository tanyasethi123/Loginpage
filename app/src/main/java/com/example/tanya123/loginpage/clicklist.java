package com.example.tanya123.loginpage;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class clicklist  extends Activity {
    public static final String EXTRA_MESSAGE1 = "no";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicklist);



        int no = (Integer)getIntent().getExtras().get(EXTRA_MESSAGE1);
        try {
            SQLiteOpenHelper Databasehelper = new Databasehelper(clicklist.this);
            SQLiteDatabase db = Databasehelper.getReadableDatabase();
            //String s="SELECT * FROM DETAILS";
            Cursor cs = db.query("DETAILS",
                    new String[]{ "FULLNAME", "USERNAME", "EMAIL"},
                    "_id=?",
                    new String[]{Integer.toString(no)}, null, null, null, null);
            if(cs.moveToFirst()) {
                final String a1 = cs.getString(0);
                final String a2 = cs.getString(1);
                final String a3 = cs.getString(2);
                TextView ta = (TextView) findViewById(R.id.t9);
                ta.setText(a1);
                TextView tb = (TextView) findViewById(R.id.t11);
                tb.setText(a2);
                TextView tc = (TextView) findViewById(R.id.t15);
                tc.setText(a3);
            }
            cs.close();
            db.close();
        } catch (Exception e) {
            Toast.makeText(clicklist.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}