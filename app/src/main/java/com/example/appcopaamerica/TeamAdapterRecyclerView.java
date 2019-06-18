package com.example.appcopaamerica;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TeamAdapterRecyclerView extends RecyclerView.Adapter<TeamAdapterRecyclerView.TeamViewHolder> {

    private ArrayList<TeamModel> teams;
    private int resource;
    private Activity activity;
    private Context context;

    public TeamAdapterRecyclerView(ArrayList<TeamModel> teams, int resource, Activity activity, Context context) {
        this.teams = teams;
        this.resource = resource;
        this.activity = activity;
        this.context = context;
    }


    @Override
    public TeamAdapterRecyclerView.TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent,false);
        return new TeamAdapterRecyclerView.TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamAdapterRecyclerView.TeamViewHolder holder, int position) {
        TeamModel team = teams.get(position);
        holder.nameTeam.setText(team.getNameTeam());

        Picasso.with(context).load(teams.get(position).getFlagTeam())
                .into((holder.flagTeam));

        holder.teamCard.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(activity, TeamActivity.class);
                activity.startActivity(intent);
            }
        }
        );
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }


    public class TeamViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTeam;
        ImageView flagTeam;
        CardView teamCard;

        public TeamViewHolder(View itemView) {
            super(itemView);

            nameTeam = (TextView)  itemView.findViewById(R.id.textTeam);
            flagTeam = (ImageView) itemView.findViewById(R.id.imgTeam);
            teamCard = (CardView)  itemView.findViewById(R.id.teamCard);
        }
    }

}
