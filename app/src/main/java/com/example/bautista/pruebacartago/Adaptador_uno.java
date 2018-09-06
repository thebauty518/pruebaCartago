package com.example.bautista.pruebacartago;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bautista.pruebacartago.Helper.RegistroAuto;

import java.util.List;

public class Adaptador_uno extends RecyclerView.Adapter<Adaptador_uno.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView Marca,Placa,Renovacion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Marca = itemView.findViewById(R.id.txtMarcaS);
            Placa =itemView.findViewById(R.id.PlacaS);
            Renovacion =itemView.findViewById(R.id.txtRenovacion);
        }
    }
    List<RegistroAuto>lista;

    public Adaptador_uno(List<RegistroAuto> lista) {
        this.lista = lista;
    }

    public Adaptador_uno.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
      @Override
    public void onBindViewHolder(@NonNull Adaptador_uno.ViewHolder viewHolder, int i) {
            viewHolder.Marca.setText(lista.get(i).getMarca());
            viewHolder.Placa.setText(lista.get(i).getPlaca());
            viewHolder.Renovacion.setText(lista.get(i).getFecSoap());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
