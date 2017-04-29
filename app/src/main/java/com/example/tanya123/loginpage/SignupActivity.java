package com.example.tanya123.loginpage;

import android.app.Activity;

import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SignupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button b =(Button) findViewById(R.id.submit2);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        EditText fn = (EditText) findViewById(R.id.fullname);
        EditText u2 = (EditText) findViewById(R.id.username2);
        EditText ma = (EditText) findViewById(R.id.email);
        EditText p2 = (EditText) findViewById(R.id.password2);
        String sa = fn.getText().toString();
        String sb = u2.getText().toString();
        String sc = ma.getText().toString();
        String sd = p2.getText().toString();
        try {
            Databasehelper Databasehelper = new Databasehelper(SignupActivity.this);
            SQLiteDatabase db = Databasehelper.getWritableDatabase();


            Databasehelper.insertvalues(db, sa, sb, sc, sd);

            Toast.makeText(getApplicationContext(), "creating account", Toast.LENGTH_SHORT).show();
            Intent I1 = new Intent(SignupActivity.this, NewaccountActivity.class);


            startActivity(I1);
            finish();
        }catch(SQLiteException e)
            {
                Toast.makeText(SignupActivity.this,e.toString(), Toast.LENGTH_LONG).show();

            }



            }

        });


    }

}