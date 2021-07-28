package com.example.webnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {


    EditText email3;
    Button buttonReset;
    TextView singUp100,logIn100;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportActionBar().hide();

        email3 =(EditText)findViewById(R.id.emailLForgotPassword);
        buttonReset = (Button)findViewById(R.id.btnForgotPassword);
        singUp100 = (TextView)findViewById(R.id.goToSingUpForgotPassword);
        logIn100 = (TextView)findViewById(R.id.goToLogInForgotPassword);
        auth = FirebaseAuth.getInstance();

        singUp100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),SingUpActivity.class));
                finish();
            }
        });

        logIn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),LogInActivity.class));
                finish();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email3ForgotPassword = email3.getText().toString().trim();
                if(TextUtils.isEmpty(email3ForgotPassword))
                {
                    email3.setError("Email Required");
                    return;
                }

                auth.sendPasswordResetEmail(email3ForgotPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(ForgotPasswordActivity.this, "Chack Your Mail", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LogInActivity.class));
                            finish();

                        }
                        else
                        {
                            Toast.makeText(ForgotPasswordActivity.this, "Erroe!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }


}