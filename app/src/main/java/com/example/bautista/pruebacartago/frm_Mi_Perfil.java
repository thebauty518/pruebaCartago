package com.example.bautista.pruebacartago;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frm_Mi_Perfil.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frm_Mi_Perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frm_Mi_Perfil extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public frm_Mi_Perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frm_Mi_Perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static frm_Mi_Perfil newInstance(String param1, String param2) {
        frm_Mi_Perfil fragment = new frm_Mi_Perfil();
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
    EditText Nombre,Fnacimiento,Fvencimiento,Correo;
    Button guardar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_frm__mi__perfil, container, false);
        Nombre = view.findViewById(R.id.txtNombre);
        Fnacimiento = view.findViewById(R.id.txtFnacimiento);
        Fvencimiento = view.findViewById(R.id.txtVenLicencia);
        Correo = view.findViewById(R.id.txtEmail);
        guardar = view.findViewById(R.id.btnGuardar);
        SharedPreferences preferences = getContext().getSharedPreferences("Datos_Usuario",Context.MODE_PRIVATE);
        final String registro = preferences.getString("Nombre_Completo","");
        if (!registro.isEmpty()){
            Nombre.setText(preferences.getString("Nombre_Completo",""));
            Fvencimiento.setText(preferences.getString("Fecha_Vencimiento",""));
            Fnacimiento.setText(preferences.getString("Fecha_Nacimiento",""));
            Correo.setText(preferences.getString("Email",""));
        }
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!registro.isEmpty()){
                    if (Nombre.getText().toString().isEmpty() || Fnacimiento.getText().toString().isEmpty() || Fvencimiento.getText().toString().isEmpty() || Correo.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "debe llenar todos los campos para actualizar", Toast.LENGTH_SHORT).show();
                    } else {
                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Datos_Usuario", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Nombre_Completo", Nombre.getText().toString());
                        editor.putString("Fecha_Nacimiento", Fnacimiento.getText().toString());
                        editor.putString("Fecha_Vencimiento", Fvencimiento.getText().toString());
                        editor.putString("Email", Correo.getText().toString());
                        editor.commit();
                        Toast.makeText(getContext(), "“REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
                        Nombre.setText("");
                        Fvencimiento.setText("");
                        Fnacimiento.setText("");
                        Correo.setText("");
                    }
                }else {
                    if (Nombre.getText().toString().isEmpty() || Fnacimiento.getText().toString().isEmpty() || Fvencimiento.getText().toString().isEmpty() || Correo.getText().toString().isEmpty()) {
                        Toast.makeText(getContext(), "Debe de llenar todos los campos para guardar", Toast.LENGTH_SHORT).show();
                    } else {
                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Datos_Usuario", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("Nombre_Completo", Nombre.getText().toString());
                        editor.putString("Fecha_Nacimiento", Fnacimiento.getText().toString());
                        editor.putString("Fecha_Vencimiento", Fvencimiento.getText().toString());
                        editor.putString("Email", Correo.getText().toString());
                        editor.commit();
                        Toast.makeText(getContext(), "NUEVO REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                        Nombre.setText("");
                        Fvencimiento.setText("");
                        Fnacimiento.setText("");
                        Correo.setText("");
                        Fragment uno = new frm_Inicio();

                    }

                }

            }
        });


        return view;
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
