package com.example.appcopaamerica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MatchesAdapter extends ArrayAdapter {

    public MatchesAdapter(Context context, List objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //Obteniendo una instancia del inflater
        LayoutInflater inflater = (LayoutInflater)getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Salvando la referencia del View de la fila
        View v = convertView;

        //Comprobando si el View no existe
        if (null == convertView) {
            //Si no existe, entonces inflarlo
            v = inflater.inflate(
                    R.layout.item_match,
                    parent,
                    false);
        }

        //Obteniendo instancias de los elementos
        TextView team1 = (TextView)v.findViewById(R.id.textTeam1);
        TextView team2 = (TextView)v.findViewById(R.id.textTeam2);
        TextView score = (TextView)v.findViewById(R.id.textScore);
        TextView dateMatch = (TextView)v.findViewById(R.id.textTeam);
        //ImageView imagenAnimal = (ImageView)v.findViewById(R.id.imagenAnimal);


        //Obteniendo instancia de la Tarea en la posición actual
        MatchModel item = (MatchModel) getItem(position);

        team1.setText(item.getTeam1());
        team2.setText(item.getTeam2());
        score.setText(item.getScore());
        dateMatch.setText(item.getDateMatch());
        //imagenAnimal.setImageResource(convertirRutaEnId(item.getImagen()));

        //Devolver al ListView la fila creada
        return v;

    }

    private int convertirRutaEnId(String nombre){
        Context context = getContext();
        return context.getResources()
                .getIdentifier(nombre, "drawable", context.getPackageName());
    }
}