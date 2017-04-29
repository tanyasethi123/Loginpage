package com.example.tanya123.loginpage;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class detailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button b1 = (Button) findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText e1 = (EditText) findViewById(R.id.username);
                EditText e2 = (EditText) findViewById(R.id.password);
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                try {
                    SQLiteOpenHelper Databasehelper = new Databasehelper(detailsActivity.this);
                    SQLiteDatabase db = Databasehelper.getReadableDatabase();

                    Cursor cs = db.query("DETAILS",
                            new String[]{"USERNAME", "PASSWORD"},
                            "USERNAME=?", new String[]{s1}, null, null, null);
                    if (cs.moveToFirst()) {
                        String n1 = cs.getString(0);
                        String n2 = cs.getString(1);

                        if (s1.equals(n1) && s2.equals(n2)) {
                            Toast.makeText(getApplicationContext(), "Logging in", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(detailsActivity.this, ExistingaccountActivity.class);
                            i.putExtra(ExistingaccountActivity.EXTRA, s1);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong details", Toast.LENGTH_SHORT).show();

                        }
                    }
                    cs.close();
                    db.close();


                } catch (SQLiteException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button b2 = (Button) findViewById(R.id.signup);
        b2.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {
                Intent I = new Intent(detailsActivity.this, SignupActivity.class);
                startActivity(I);

            }
        });

        Button b3 = (Button) findViewById(R.id.listview);
        b3.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {
                Intent A = new Intent(detailsActivity.this, Listdetails.class);
                startActivity(A);
            }


});
    }
}
