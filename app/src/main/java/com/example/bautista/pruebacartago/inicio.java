package com.example.bautista.pruebacartago;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class inicio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        SharedPreferences sharedPreferences = getSharedPreferences("Datos_Usuario",MODE_PRIVATE);
        String registro = sharedPreferences.getString("Nombre_Completo","");
        if (!registro.isEmpty()) {
            Intent uno = new Intent(this, Navigation.class);
            startActivity(uno);
            finish();
        }

    }
    public void perfil(View view){
        Intent Menu = new Intent(this, Navigation.class );
        startActivity(Menu);
    }


}
