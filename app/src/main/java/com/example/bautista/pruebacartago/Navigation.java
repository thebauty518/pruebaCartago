package com.example.bautista.pruebacartago;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, frm_Mi_Perfil.OnFragmentInteractionListener
,frm_Inicio.OnFragmentInteractionListener,frm_Registro_de_Autos.OnFragmentInteractionListener,frm_Servicios.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SharedPreferences sharedPreferences = this.getSharedPreferences("Datos_Usuario",MODE_PRIVATE);
        String registro = sharedPreferences.getString("Nombre_Completo","");

        if (!registro.isEmpty()){
            Fragment uno = new frm_Inicio();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,uno).commit();
        }else{
            Fragment uno = new frm_Mi_Perfil();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,uno).commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment miFragment = null;
        Boolean  seleccionado = false;

        if (id == R.id.Inicio) {
            miFragment =new frm_Inicio();
            seleccionado = true;
        } else if (id == R.id.Registro_Autos) {
            miFragment =new frm_Registro_de_Autos();
            seleccionado = true;
        } else if (id == R.id.Servicios) {
            miFragment =new frm_Servicios();
            seleccionado = true;
        } else if (id == R.id.Mi_Perfil) {
            miFragment =new frm_Mi_Perfil();
            seleccionado = true;
        } else if (id == R.id.Acerca_de) {

        } else if (id == R.id.Salir) {

        }
        if (seleccionado==true){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
