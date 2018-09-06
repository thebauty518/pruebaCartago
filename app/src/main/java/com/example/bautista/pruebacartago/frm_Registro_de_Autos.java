package com.example.bautista.pruebacartago;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bautista.pruebacartago.Helper.Ciudad;
import com.example.bautista.pruebacartago.Helper.Color;
import com.example.bautista.pruebacartago.Helper.Marca;
import com.example.bautista.pruebacartago.Helper.RegistroAuto;
import com.example.bautista.pruebacartago.Helper.SQLiteHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frm_Registro_de_Autos.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frm_Registro_de_Autos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frm_Registro_de_Autos extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public frm_Registro_de_Autos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frm_Registro_de_Autos.
     */
    // TODO: Rename and change types and number of parameters
    public static frm_Registro_de_Autos newInstance(String param1, String param2) {
        frm_Registro_de_Autos fragment = new frm_Registro_de_Autos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }






    View view;
    Spinner spMarca,spColor, spCiudad;

    EditText txtPlacas, txtModelos, txtFecSoat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frm__registro_de__autos, container, false);


        txtPlacas=(EditText)view.findViewById(R.id.txtPlaca);
        txtModelos=(EditText)view.findViewById(R.id.txtModelo);
        txtFecSoat=(EditText)view.findViewById(R.id.txtFsoap);


        spMarca=(Spinner)view.findViewById(R.id.spMarca);
        spColor=(Spinner)view.findViewById(R.id.spColor);
        spCiudad=(Spinner)view.findViewById(R.id.spCiudad);


        String marca[]={"AUDI", "FIAT", "ALFA ROMEO"};
        String colores[]={"AMARILLO", "AZULBEIGE", "BLANCO", "GRIS", "MARRON", "MORADO", "NARANJA", "NEGRO", "ROJO", "VERDE"};
        String ciudades[]={"CARTAGO", "CALI", "BOGOTA", "MEDELLIN", "BARRANQUILLA"};


       /* ArrayAdapter marca1 =new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item, marca);
        spMarca.setAdapter(marca1);*/

        ArrayAdapter marca1 =new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item, mtdMarca() );
        spMarca.setAdapter(marca1);

        ArrayAdapter color= new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,mtdColor());
        spColor.setAdapter(color);

        ArrayAdapter ciudad = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item, mtdCiudad());
        spCiudad.setAdapter(ciudad);

        return view;
    }

    public void mtdRegistrar(View view){


        SQLiteHelper base = new SQLiteHelper(getContext(), "Cartago.bd", null, 1);
        SQLiteDatabase datos = base.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("Placa",txtPlacas.getText().toString());
        values.put("Modelo",txtModelos.getText().toString());
        values.put("FecSoap", txtFecSoat.getText().toString());
        values.put("Marca", spMarca.getSelectedItem().toString());
        values.put("Color", spColor.getSelectedItem().toString());
        values.put("Ciudad", spCiudad.getSelectedItem().toString());

        datos.insert("tbl_regautosx",null, values);


    }

    ArrayList<String> baseColor = new ArrayList<>();
    ArrayList<String> baseCiudad = new ArrayList<>();
    ArrayList<String> baseMarca = new ArrayList<>();
    Color color = null;
    Marca marca = null;
    Ciudad ciudad = null;



    private List mtdColor() {

        SQLiteHelper dato = new SQLiteHelper(getContext(),"Cartago.db", null , 1);

        SQLiteDatabase database = dato.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT Color FROM tbl_colores", null);

        while (cursor.moveToNext()){

            color= new Color();
            color.setColor(cursor.getString(0));
            baseColor.add(color.getColor());
        }

        return baseColor;
    }

    private List mtdCiudad() {

        SQLiteHelper dato = new SQLiteHelper(getContext(),"Cartago.db", null , 1);

        SQLiteDatabase database = dato.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT Ciudad FROM tbl_ciudades", null);

        while (cursor.moveToNext()){

            ciudad= new Ciudad();
            ciudad.setCiudad(cursor.getString(0));
            baseCiudad.add(ciudad.getCiudad());
        }

        return baseCiudad;
    }
    private List mtdMarca() {

        SQLiteHelper dato = new SQLiteHelper(getContext(),"Cartago.db", null , 1);

        SQLiteDatabase database = dato.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT Marca FROM tbl_marcautos", null);

        while (cursor.moveToNext()){

            marca= new Marca();
            marca.setMarca(cursor.getString(0));
            baseMarca.add(marca.getMarca());
        }

        return baseMarca;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
