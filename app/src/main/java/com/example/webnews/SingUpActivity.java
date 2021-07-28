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

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingUpActivity extends AppCompatActivity {

    TextView textView;
    Button buttonSingUp;
    EditText name,email1,password1;
    FirebaseAuth auth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        getSupportActionBar().hide();

        textView = (TextView)findViewById(R.id.textViewSingUp);
        buttonSingUp = (Button)findViewById(R.id.btnSingUp);
        name = (EditText)findViewById(R.id.nameSingUp);
        email1 = (EditText)findViewById(R.id.emailSingUp);
        password1 = (EditText)findViewById(R.id.passwordSingUp);
        auth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(SingUpActivity.this);
        progressDialog.setTitle("Creating account");
        progressDialog.setMessage("We are creating your account");


        if(auth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        buttonSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail1 = email1.getText().toString().trim();
                String mPassword1 = password1.getText().toString().trim();

                if(TextUtils.isEmpty(mEmail1))
                {
                    email1.setError("email required");
                    return;
                }
                if(TextUtils.isEmpty(mPassword1))
                {
                    password1.setError("Password is required");
                    return;
                }
                if(mPassword1.length() < 6)
                {
                    password1.setError("character must be grater then 6");

                }

                progressDialog.show();

                auth.createUserWithEmailAndPassword(mEmail1,mPassword1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();

                        if(task.isSuccessful())
                        {
                            Toast.makeText(SingUpActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                        else
                        {
                            Toast.makeText(SingUpActivity.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });



            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),LogInActivity.class));
                finish();

            }
        });


    }
}