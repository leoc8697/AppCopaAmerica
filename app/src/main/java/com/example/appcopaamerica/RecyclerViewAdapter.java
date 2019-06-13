package com.example.appcopaamerica;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView team1, team2, score, dateMatch;
        ImageView flagTeam1,flagTeam2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team1=(TextView)itemView.findViewById(R.id.textView2);
            team2=(TextView)itemView.findViewById(R.id.textView4);
            score=(TextView)itemView.findViewById(R.id.textView3);
            dateMatch=(TextView)itemView.findViewById(R.id.textView5);
            flagTeam1=(ImageView)itemView.findViewById(R.id.imageView4);
            flagTeam2=(ImageView)itemView.findViewById(R.id.imageView5);

        }
    }

    public List<MatchModel> matchList;

    public RecyclerViewAdapter(List<MatchModel> matchList) {
        this.matchList = matchList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        //El siguiente paso es inflar, que significa hacer uso de un layout dentro de otro layout.
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_fragment,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    //El metodo onBindViewHolder realiza las verificaciones del contenido para cada item.


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.team1.setText(matchList.get(position).getTeam1());
        holder.team2.setText(matchList.get(position).getTeam2());
        holder.score.setText(matchList.get(position).getScore());
        holder.dateMatch.setText(matchList.get(position).getDateMatch());
        holder.flagTeam1.setImageResource(matchList.get(position).getFlagTeam1());
        holder.flagTeam2.setImageResource(matchList.get(position).getFlagTeam2());
    }

    //El siguiente metodo permita configurar al adaptador la cantidad de elementos que se procesarán.

    @Override
    public int getItemCount() {
        return matchList.size();
    }
}
