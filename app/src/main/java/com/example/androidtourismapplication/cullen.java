package com.example.androidtourismapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class cullen extends AppCompatActivity {

    Button btn;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cullenbeach);
        }

    public void OPEN(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}

