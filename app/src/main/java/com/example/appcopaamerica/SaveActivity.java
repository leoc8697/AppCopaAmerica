package com.example.appcopaamerica;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SaveActivity extends AppCompatActivity {

    private ListView lvItems;
    private Adaptador adaptador;

    MatchAdapterRecyclerView adapterMatch;
    ArrayList<MatchModel> matchesList = new ArrayList<>();
    ArrayList<MatchModelDb> dbmatchesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        getSupportActionBar().hide();

         lvItems= (ListView) findViewById(R.id.lvItems);
         adaptador = new Adaptador(this,getMatchs());
         lvItems.setAdapter(adaptador);


    }

    private void getTasks() {
        class GetTasks extends AsyncTask<Void, Void, List<MatchModelDb>> {

            @Override
            protected List<MatchModelDb> doInBackground(Void... voids) {
                List<MatchModelDb> taskList = MatchItemDatabaseAccesor
                        .getInstance(getApplication()).MatchItemDAO().loadAllItems();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<MatchModelDb> tasks) {
                super.onPostExecute(tasks);

                dbmatchesList.clear();
                for (int i = 0; i < tasks.size(); i++) {
                    MatchModel ObjMatch=new MatchModel(tasks.get(i).getTeam1(),tasks.get(i).getTeam2(),tasks.get(i).getScore(),
                            tasks.get(i).getDateMatch(),tasks.get(i).getFlagTeam1(),tasks.get(i).getFlagTeam2());
                    matchesList.add(ObjMatch);
                }

            }
        }
        GetTasks getTasks = new GetTasks();
        getTasks.execute();

    }
    public ArrayList<MatchModel> getMatchs(){

        ArrayList<MatchModel> matches = new ArrayList<>();
        matches.add(new MatchModel("Brasil", "Bolivia", "Hora", "   Viernes 14 Junio","https://i.postimg.cc/mth4Crn6/japon-round.png","https://i.postimg.cc/mth4Crn6/japon-round.png"));//, R.mipmap.brasil_round, R.mipmap.bolivia_round));
        matches.add(new MatchModel("Brasil2", "Bolivia2", "Hora2", "   Viernes2","https://i.postimg.cc/mth4Crn6/japon-round.png","https://i.postimg.cc/mth4Crn6/japon-round.png"));//, R.mipmap.brasil_round, R.mipmap.bolivia_round));
        //match.add(new MatchModel("Brasil3", "Hora3", "Bolivia3", "Viernes3",R.drawable.br,R.drawable.bo));

        return matches;
    }
}
