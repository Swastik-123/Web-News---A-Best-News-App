package com.example.webnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        Thread thread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(4000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                finally
                {
                    startActivity(new Intent(getApplicationContext(),LogInActivity.class));
                    finish();
                }
            }
        };thread.start();

    }
}