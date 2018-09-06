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


    //tabla regautosx

     sqLiteDatabase.execSQL("CREATE TABLE tbl_regautosx (\n" +
             "    Marca   VARCHAR,\n" +
             "    Color   VARCHAR,\n" +
             "    Placa   VARCHAR PRIMARY KEY,\n" +
             "    Ciudad  VARCHAR,\n" +
             "    Modelo  INTEGER,\n" +
             "    FecSoap DATE\n" +
             ");\n");


     //tabla marcautos
     sqLiteDatabase.execSQL("CREATE TABLE tbl_marcautos (\n" +
             "    idMarca INTEGER PRIMARY KEY,\n" +
             "    Marca   VARCHAR\n" +
             ");\n");


     sqLiteDatabase.execSQL("INSERT INTO tbl_marcautos (Marca)Values('AUDI'),('FIAT'),('ALFA ROMEO')");


     //tabla colores
     sqLiteDatabase.execSQL("CREATE TABLE tbl_colores (\n" +
             "    idColor INTEGER PRIMARY KEY,\n" +
             "    Color   VARCHAR\n" +
             ");\n");

    sqLiteDatabase.execSQL("INSERT INTO tbl_colores (Color)Values('AMARILLO'),('AZULBEIGE'),('BLANCO')" +
            ",('CAFE'),('GRIS'),('MARRON'),('MORADO'),('NARANJA'),('NEGRO'),('ROJO'),('VERDE') ");

    //tabla ciudades
    sqLiteDatabase.execSQL("CREATE TABLE tbl_ciudades (\n" +
            "    idCiudades INTEGER PRIMARY KEY,\n" +
            "    Ciudad     VARCHAR\n" +
            ");\n");

    sqLiteDatabase.execSQL("INSERT INTO tbl_ciudades (Ciudad)Values('CARTAGO'),('CALI'),('BOGOTA'),('MEDELLIN'),('BARRANQUILLA') ");


    //tabla impuesto Carro


     sqLiteDatabase.execSQL("CREATE TABLE tbl_impuesto_carro (\n"+
             " idImpuesto INTEGER PRIMARY KEY, \n"+
             " Ciudad VARCHAR,\n"+
             " Mes VARCHAR,\n"+
             " Numero_ini,\n"+
             " Numero_fin,\n"+
             " Año\n"+
             ");\n");

     sqLiteDatabase.execSQL("INSERT INTO tbl_impuesto_carro (Ciudad, Mes, Numero_ini, Numero_fin" +
             ", Año)Values('CARTAGO', 'MARZO', '000', '333', '2018')");

    sqLiteDatabase.execSQL("INSERT INTO tbl_impuesto_carro (Ciudad, Mes, Numero_ini, Numero_fin" +
            ", Año)Values('CARTAGO', 'ABRIL', '334', '666', '2018')");

    sqLiteDatabase.execSQL("INSERT INTO tbl_impuesto_carro (Ciudad, Mes, Numero_ini, Numero_fin" +
            ", Año)Values('CARTAGO', 'MAYO', '667', '999', '2018')");



    sqLiteDatabase.execSQL("INSERT INTO tbl_impuesto_carro (Ciudad, Mes, Numero_ini, Numero_fin" +
            ", Año)Values('BOGOTA', 'JUNIO', '000', '333', '2018')");

    sqLiteDatabase.execSQL("INSERT INTO tbl_impuesto_carro (Ciudad, Mes, Numero_ini, Numero_fin" +
            ", Año)Values('BOGOTA', 'JUlIO', '334', '666', '2017')");

    sqLiteDatabase.execSQL("INSERT INTO tbl_impuesto_carro (Ciudad, Mes, Numero_ini, Numero_fin" +
            ", Año)Values('BOGOTA', 'AGOSTO', '667', '999', '2017')");





    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
