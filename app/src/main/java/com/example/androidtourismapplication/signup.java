package com.example.androidtourismapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class signup extends AppCompatActivity {

    TextView textView2;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.signup);


        textView2 = (TextView)findViewById(R.id.textView2);
        textView4 = (TextView)findViewById(R.id.textView4);

        textView2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);

                Toast.makeText(signup.this, "Login to an Account", Toast.LENGTH_LONG).show();
            }
        });

        textView4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(signup.this, "Skipped", Toast.LENGTH_LONG).show();
            }
        });




    }

}
