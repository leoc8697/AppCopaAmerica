package com.example.appcopaamerica;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MatchAdapterRecyclerView extends RecyclerView.Adapter<MatchAdapterRecyclerView.MatchViewHolder> {

    private ArrayList<MatchModel> matches;
    private int resource;
    private Activity activity;

    public MatchAdapterRecyclerView(ArrayList<MatchModel> matches, int resource, Activity activity) {
        this.matches = matches;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //El siguiente paso es inflar, que significa hacer uso de un layout dentro de otro layout.
        View view= LayoutInflater.from(parent.getContext()).inflate(resource, parent,false);
        return new MatchViewHolder(view);
    }


    //El metodo onBindViewHolder realiza las verificaciones del contenido para cada item.
    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {

        holder.team1.setText(matches.get(position).getTeam1());
        holder.team2.setText(matches.get(position).getTeam2());
        holder.score.setText(matches.get(position).getScore());
        holder.dateMatch.setText(matches.get(position).getDateMatch());
        //holder.flagTeam1.setImageResource(matches.get(position).getFlagTeam1());
        //holder.flagTeam2.setImageResource(matches.get(position).getFlagTeam2());
    }

    //El siguiente metodo permita configurar al adaptador la cantidad de elementos que se procesarán.

    @Override
    public int getItemCount() {
        return matches.size();
    }

    //Esta clase se centra sólo en una card.
    public class MatchViewHolder extends RecyclerView.ViewHolder{

        private TextView team1, team2, score, dateMatch;
       // ImageView flagTeam1,flagTeam2;

        public MatchViewHolder(View itemView) {
            super(itemView);

            team1     = (TextView) itemView.findViewById(R.id.textTeam1);
            team2     = (TextView) itemView.findViewById(R.id.textTeam2);
            score     = (TextView) itemView.findViewById(R.id.textScore);
            dateMatch = (TextView) itemView.findViewById(R.id.textDateMatch);
           // flagTeam1 = (ImageView)itemView.findViewById(R.id.imgTeam1);
           // flagTeam2 = (ImageView)itemView.findViewById(R.id.imgTeam2);
        }
    }
}
