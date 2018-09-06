package com.example.bautista.pruebacartago;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashop);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Menu = new Intent(Splash.this, inicio.class );
                startActivity(Menu);
                finish();
            }
        },10000);
    }
}
