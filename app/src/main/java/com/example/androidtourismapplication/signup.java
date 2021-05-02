package com.example.androidtourismapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.Objects;

public class signup extends AppCompatActivity {

    EditText mEmail, mPassword;
    Button mButtonSU;
    FirebaseAuth fAuth;


    TextView textView2;
    TextView textView4;

    private Button buttonSU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.signup);







        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
//        progressBar = findViewById(R.id.progressBar);
        mButtonSU = (Button)findViewById(R.id.buttonSU);

        textView2 = (TextView)findViewById(R.id.textView2);
        textView4 = (TextView)findViewById(R.id.textView4);



        if(fAuth.getCurrentUser()!= null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }





        mButtonSU.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    mEmail.setError(("email is Required"));
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    mPassword.setError(("Password is Required"));
                    return;
                }

                if (password.length()<6){
                    mPassword.setError(("Password must contain more than 6 characters."));
                    return;
                }



//                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(signup.this, "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });




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
