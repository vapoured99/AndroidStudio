package com.example.androidtourismapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;


public class login extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        textView = (TextView)findViewById(R.id.register);
        textView2 = (TextView)findViewById(R.id.skip);

        textView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);

                Toast.makeText(login.this, "Create an account", Toast.LENGTH_LONG).show();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(login.this, "Skipped", Toast.LENGTH_LONG).show();
            }
        });



    }

}
