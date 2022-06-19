package com.felipe.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity();
            }
        }, 5000);
    }

    private void MainActivity(){
        Intent intent = new Intent(splashscreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
