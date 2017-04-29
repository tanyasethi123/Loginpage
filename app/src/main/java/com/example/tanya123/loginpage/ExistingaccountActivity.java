package com.example.tanya123.loginpage;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExistingaccountActivity extends AppCompatActivity {
    public static final String EXTRA = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existingaccount);
        Intent i = getIntent();
        String s1 = i.getStringExtra(EXTRA);
        TextView t1 = (TextView) findViewById(R.id.display);
        t1.setText(s1);

        Button closeButton = (Button) findViewById(R.id.buttonClose);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
