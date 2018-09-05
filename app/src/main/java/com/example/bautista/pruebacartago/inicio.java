package com.example.bautista.pruebacartago;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity implements frm_Mi_Perfil.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    public void perfil(View view){
        Fragment uno = new frm_Mi_Perfil();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,uno).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
