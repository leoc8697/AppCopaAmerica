package com.example.appcopaamerica;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.security.AccessController;
import java.util.ArrayList;

import static java.security.AccessController.getContext;


public class MatchAdapterRecyclerView extends RecyclerView.Adapter<MatchAdapterRecyclerView.MatchViewHolder> {

    private ArrayList<MatchModel> matches;
    private int resource;
    private Activity activity;
    private  Context context;



    public MatchAdapterRecyclerView(ArrayList<MatchModel> matches, int resource, Activity activity, Context context) {
        this.matches = matches;
        this.context = context;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //El siguiente paso es inflar, que significa hacer uso de un layout dentro de otro layout.
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent,false);
        return new MatchViewHolder(view);
    }


    //El metodo onBindViewHolder realiza las verificaciones del contenido para cada item.
    @Override
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        MatchModel match = matches.get(position);
        holder.team1.setText(match.getTeam1());
        holder.team2.setText(match.getTeam2());
        holder.score.setText(match.getScore());
        holder.dateMatch.setText(match.getDateMatch());
        Picasso.with(context).load(matches.get(position).getFlagTeam1())
                .into((holder.flagTeam1));
        Picasso.with(context).load(matches.get(position).getFlagTeam2())
                .into((holder.flagTeam2));

    }

    //El siguiente metodo permita configurar al adaptador la cantidad de elementos que se procesarán.

    @Override
    public int getItemCount() {
        return matches.size();
    }

    //Esta clase se centra sólo en una card.
    public class MatchViewHolder extends RecyclerView.ViewHolder{

        private TextView team1, team2, score, dateMatch;
        ImageView flagTeam1,flagTeam2;

        public MatchViewHolder(View itemView) {
            super(itemView);

            team1     = (TextView)  itemView.findViewById(R.id.textTeam1);
            team2     = (TextView)  itemView.findViewById(R.id.textTeam2);
            score     = (TextView)  itemView.findViewById(R.id.textScore);
            dateMatch = (TextView)  itemView.findViewById(R.id.textDateMatch);
            flagTeam1 = (ImageView) itemView.findViewById(R.id.imgTeam1);
            flagTeam2 = (ImageView) itemView.findViewById(R.id.imgTeam2);
        }
    }
}