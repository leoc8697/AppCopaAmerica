package com.example.appcopaamerica;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SaveActivity extends AppCompatActivity {

    MatchAdapterRecyclerView adapterMatch;
    ArrayList<MatchModel> matchesList = new ArrayList<>();
    ArrayList<MatchModelDb> dbmatchesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        MatchAdapterRecyclerView adapterMatch;


        //Vinculamos nuestra instancia recycler view
        RecyclerView recyclerViewMatch = (RecyclerView) findViewById(R.id.recyclerMatch);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewMatch.setLayoutManager(linearLayoutManager);


        getTasks();

        //Aquí asignamos toda la info de nuestro recycler view en nuestro layout
        adapterMatch = new MatchAdapterRecyclerView(matchesList, R.layout.item_match, this, this);
        recyclerViewMatch.setAdapter(adapterMatch);


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

}
