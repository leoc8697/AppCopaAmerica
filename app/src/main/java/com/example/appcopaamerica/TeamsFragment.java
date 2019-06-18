package com.example.appcopaamerica;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class TeamsFragment extends Fragment {

    ArrayList<TeamModel> teamsList = new ArrayList<>();
    TeamAdapterRecyclerView adapterTeam;

    public TeamsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams, container, false);

        RecyclerView recyclerViewTeam = (RecyclerView) view.findViewById(R.id.recyclerTeam);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewTeam.setLayoutManager(linearLayoutManager);

        getTeamParsed();

        //Aquí asignamos toda la info de nuestro recycler view en nuestro layout
        adapterTeam = new TeamAdapterRecyclerView(teamsList, R.layout.item_team, getActivity(), getActivity().getApplicationContext());
        recyclerViewTeam.setAdapter(adapterTeam);

        return view;
    }

    private void getTeamParsed()

    {
        class JsonTask extends AsyncTask<URL, Void, ArrayList<TeamModel>> {

            @Override
            protected ArrayList<TeamModel> doInBackground(URL... urls) {
                ArrayList<TeamModel> teams = null;

                try {
                    //URL Json only text.
                    //URL url = new URL("https://api.myjson.com/bins/1eqw2d");
                    //URL Json text and images.
                    URL url = new URL("https://api.myjson.com/bins/10a55h");
                    // Create a new HTTP URL connection
                    URLConnection connection = url.openConnection();
                    HttpURLConnection httpConnection = (HttpURLConnection) connection;
                    int responseCode = httpConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream in = httpConnection.getInputStream();

                        // Parsear el flujo con formato JSON
                        GsonTeamParser parser = new GsonTeamParser();
                        teams = (ArrayList<TeamModel>) parser.readFlowJson(in);
                    }
                    else{
                        teams = new ArrayList<>();
                        teams.add(new TeamModel(null, null));
                    }
                    httpConnection.disconnect();
                } catch (MalformedURLException e) {
                    Log.e(TAG, "Malformed URL Exception.", e);
                } catch (IOException e) {
                    Log.e(TAG, "IO Exception.", e);
                }
                return teams;
            }

            @Override
            protected void onPostExecute(ArrayList<TeamModel> teams) {

                super.onPostExecute(teams);
                if(teams!=null) {
                    teamsList.clear();

                    for (int i = 0; i < teams.size(); i++) {
                        teamsList.add(teams.get(i));

                    }
                    adapterTeam.notifyDataSetChanged();
                }
                else{
                    Toast.makeText((MainActivity) getContext(),
                            "Ocurrió un error de Parsing Json",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }

        }

        JsonTask jsonTask = new JsonTask();
        jsonTask.execute();
    }


}
