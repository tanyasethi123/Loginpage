package com.example.tanya123.loginpage;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Listdetails extends ListActivity {
    Cursor cus;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdetails);
        ListView listView = (ListView) findViewById(android.R.id.list);
        try {
            SQLiteOpenHelper Databasehelper = new Databasehelper(Listdetails.this);
           db = Databasehelper.getReadableDatabase();
            cus= db.query("DETAILS",
                    new String[]{"_id", "FULLNAME"},
                    null, null, null, null, null);

            final SimpleCursorAdapter list = new SimpleCursorAdapter(Listdetails.this, R.layout.list_item,
                    cus, new String[]{"FULLNAME"}, new int[]{R.id.name}, 0);

            listView.setAdapter(list);

           /*

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TextView t = (TextView) view.findViewById(R.id.name);
            //String s1 = t.getText().toString();
            //Toast.makeText(Listdetails.this,t.getText(),Toast.LENGTH_SHORT).show();
            Cursor cur = (Cursor) list.getItem(position);
            cur.moveToPosition(position);
            TextView t = (TextView) view.findViewById(R.id.name);
            String s1 = t.getText().toString();
            if (s1 == a1) {
                Intent in = new Intent(Listdetails.this, clicklist.class);
                in.putExtra("EXTRA_MESSAGE", a2);
                //in.putExtra(EX,a3);
                startActivity(in);
        }
    }
});
*/



        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        cus.close();
        db.close();

    }

    @Override
    public void onListItemClick (ListView listView,
                                 View itemView,
                                 int position,
                                 long id){
        Intent intent = new Intent(Listdetails.this, clicklist.class);
        intent.putExtra(clicklist.EXTRA_MESSAGE1,(int)id);
        startActivity(intent);

    }
}
