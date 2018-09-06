package com.example.bautista.pruebacartago.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {


    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



     sqLiteDatabase.execSQL("CREATE TABLE tbl_regautosx (\n" +
             "    Marca   VARCHAR,\n" +
             "    Color   VARCHAR,\n" +
             "    Placa   VARCHAR PRIMARY KEY,\n" +
             "    Ciudad  VARCHAR,\n" +
             "    Modelo  INTEGER,\n" +
             "    FecSoap VARCHAR\n" +
             ");\n");


     sqLiteDatabase.execSQL("CREATE TABLE tbl_marcautos (\n" +
             "    idMarca INTEGER PRIMARY KEY,\n" +
             "    Marca   VARCHAR\n" +
             ");\n");

     sqLiteDatabase.execSQL("INSERT INTO tbl_marcautos (Marca)Values('AUDI'),('FIAT'),('ALFA ROMEO')");


     sqLiteDatabase.execSQL("CREATE TABLE tbl_colores (\n" +
             "    idColor INTEGER PRIMARY KEY,\n" +
             "    Color   VARCHAR\n" +
             ");\n");

    sqLiteDatabase.execSQL("INSERT INTO tbl_colores (Color)Values('AMARILLO'),('AZULBEIGE'),('BLANCO')" +
            ",('CAFE'),('GRIS'),('MARRON'),('MORADO'),('NARANJA'),('NEGRO'),('ROJO'),('VERDE') ");

    sqLiteDatabase.execSQL("CREATE TABLE tbl_ciudades (\n" +
            "    idCiudades INTEGER PRIMARY KEY,\n" +
            "    Ciudad     VARCHAR\n" +
            ");\n");

    sqLiteDatabase.execSQL("INSERT INTO tbl_ciudades (Ciudad)Values('CARTAGO'),('CALI'),('BOGOTA'),('MEDELLIN'),('BARRANQUILLA') ");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
