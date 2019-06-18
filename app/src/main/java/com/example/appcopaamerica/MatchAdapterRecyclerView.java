package com.example.appcopaamerica;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MatchAdapterRecyclerView extends RecyclerView.Adapter<MatchAdapterRecyclerView.MatchViewHolder> {

    //EventoOnItemClick listener;

    private ArrayList<MatchModel> matches;
    private int resource;
    private Activity activity;
    private  Context context;

    public MatchAdapterRecyclerView(ArrayList<MatchModel> matches, int resource, Activity activity, Context context) {
        this.matches = matches;
        this.resource = resource;
        this.activity = activity;
        this.context = context;
    }

    @Override
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //El siguiente paso es inflar, que significa hacer uso de un layout dentro de otro layout.
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent,false);
        return new MatchViewHolder(view);
    }


    //El metodo onBindViewHolder realiza las verificaciones del contenido para cada item.
    @Override
    public void onBindViewHolder(final MatchViewHolder holder, int position) {
        final MatchModel match = matches.get(position);
        holder.team1.setText(match.getTeam1());
        holder.team2.setText(match.getTeam2());
        holder.score.setText(match.getScore());
        holder.dateMatch.setText(match.getDateMatch());
        Picasso.with(context).load(matches.get(position).getFlagTeam1())
                .into((holder.flagTeam1));
        Picasso.with(context).load(matches.get(position).getFlagTeam2())
                .into((holder.flagTeam2));
        holder.team1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MatchModelDb task = new MatchModelDb(match.getTeam1() ,match.getTeam2(),match.getScore(),match.getDateMatch(),
                        match.getFlagTeam1(),match.getFlagTeam2());
                saveTask(task);
                Toast.makeText(context,holder.team1.getText(),Toast.LENGTH_SHORT).show();
            }
        });

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
            dateMatch = (TextView)  itemView.findViewById(R.id.textTeam);
            flagTeam1 = (ImageView) itemView.findViewById(R.id.imgTeam);
            flagTeam2 = (ImageView) itemView.findViewById(R.id.imgTeam2);
        }
    }
/*
    public interface EventoOnItemClick {
        public void onItemClick(int posicion);
    }

    public void setOnClickListener(EventoOnItemClick listener){
        this.listener=listener;
    }

    public class ItemMenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        EventoOnItemClick listener; // Recibe la interfaz enviada desde el adaptador
        int posicion; // Recibe la posicion enviada desde le adaptador

        public ItemMenuViewHolder(View itemView, EventoOnItemClick listener) {
            super(itemView);

            // Apuntas el evento onClick del item al metodo onClick
            // de la interfaz OnClickListener.
            itemView.setOnClickListener(this);

            // Inicializas el listener
            this.listener = listener;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion; // Inicializa la posicion
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(posicion);
        }

    } */

    private void saveTask(final MatchModelDb task) {
        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                //adding to database
                MatchItemDatabaseAccesor.getInstance(context).MatchItemDAO().insertMatchItem(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);


                Toast.makeText(context,
                        "guardando en base de datos",
                        Toast.LENGTH_SHORT)
                        .show();
                /*getTasks();
                Toast.makeText(context,
                        dbMatchItems.get(1).getFlagTeam1(),
                        Toast.LENGTH_SHORT)
                        .show();  */



            }
        }

        SaveTask saveTask = new SaveTask();
        saveTask.execute();
    }
}
