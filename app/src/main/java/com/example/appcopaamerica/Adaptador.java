package com.example.appcopaamerica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appcopaamerica.MatchModel;
import com.example.appcopaamerica.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;

    private ArrayList<MatchModel> listItems;

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {

        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public Adaptador(Context context, ArrayList<MatchModel> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MatchModel item = (MatchModel) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_match,null);
        TextView team1     = (TextView)  convertView.findViewById(R.id.textTeam1);
        TextView   team2     = (TextView)  convertView.findViewById(R.id.textTeam2);
        TextView  score     = (TextView)  convertView.findViewById(R.id.textScore);
        TextView dateMatch = (TextView)  convertView.findViewById(R.id.textTeam);
        ImageView  flagTeam1 = (ImageView) convertView.findViewById(R.id.imgTeam);
        ImageView flagTeam2 = (ImageView) convertView.findViewById(R.id.imgTeam2);

        team1.setText(item.getTeam1());
        team2.setText(item.getTeam2());
        score.setText(item.getScore());
        dateMatch.setText(item.getDateMatch());
        Picasso.with(context).load(item.getFlagTeam1())
                .into((flagTeam1));
        Picasso.with(context).load(item.getFlagTeam2())
                .into((flagTeam2));

        return convertView;
    }
}
