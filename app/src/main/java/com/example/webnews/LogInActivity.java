package com.example.webnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    EditText email2,password2;
    Button buttonLogIn;
    TextView fb,singUp;
    ProgressDialog progressDialog;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().hide();

        email2 = (EditText)findViewById(R.id.emailLForgotPassword);
        password2 = (EditText)findViewById(R.id.passwordLogIn);
        buttonLogIn = (Button)findViewById(R.id.btnForgotPassword);
        fb = (TextView)findViewById(R.id.forgotPassword);
        singUp = (TextView)findViewById(R.id.goToSingUpForgotPassword);
        auth = FirebaseAuth.getInstance();


        progressDialog = new ProgressDialog(LogInActivity.this);
        progressDialog.setTitle("Founding Account");
        progressDialog.setMessage("Wait");

        if(auth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),SingUpActivity.class));
                finish();

            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LogInActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email2LogIn = email2.getText().toString().trim();
                String password2LogIn = password2.getText().toString().trim();

                if(TextUtils.isEmpty(email2LogIn))
                {
                    email2.setError("Email Required");
                    return;
                }

                if(TextUtils.isEmpty(password2LogIn))
                {
                    password2.setError("Password Required");
                    return;
                }

                if(password2LogIn.length() < 6)
                {
                    password2.setError("Password must be grater then 6");
                }

                progressDialog.show();
                auth.signInWithEmailAndPassword(email2LogIn,password2LogIn).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            Toast.makeText(LogInActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            finish();

                        }
                        else {

                            Toast.makeText(LogInActivity.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });


    }
}