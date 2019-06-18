package com.example.appcopaamerica;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class CalendarFragment extends Fragment {

    ArrayList<MatchModel> matchesList = new ArrayList<>();
    MatchAdapterRecyclerView adapterMatch;

    public CalendarFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar_fragment, container, false);

        FloatingActionButton fab = view.findViewById(R.id.boSave);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),
                        "aquí va la inflación",
                        Toast.LENGTH_SHORT)
                        .show();
                Intent intent = new Intent(getActivity(),SaveActivity.class);
                startActivity(intent);

            }
        });

        //Vinculamos nuestra instancia recycler view
        RecyclerView recyclerViewMatch = (RecyclerView) view.findViewById(R.id.recyclerMatch);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewMatch.setLayoutManager(linearLayoutManager);

        getMatchParsed();

        //Aquí asignamos toda la info de nuestro recycler view en nuestro layout
        adapterMatch = new MatchAdapterRecyclerView(matchesList, R.layout.item_match, getActivity(), getActivity().getApplicationContext());
        recyclerViewMatch.setAdapter(adapterMatch);

        return view;
    }
/*
    public ArrayList<MatchModel> getMatchs(){

        ArrayList<MatchModel> matches = new ArrayList<>();
        matches.add(new MatchModel("Brasil", "Bolivia", "Hora", "   Viernes 14 Junio"));//, R.mipmap.brasil_round, R.mipmap.bolivia_round));
        matches.add(new MatchModel("Brasil2", "Bolivia2", "Hora2", "   Viernes2"));//, R.mipmap.brasil_round, R.mipmap.bolivia_round));
        //match.add(new MatchModel("Brasil3", "Hora3", "Bolivia3", "Viernes3",R.drawable.br,R.drawable.bo));

        return matches;
    }
    */

private void getMatchParsed()

    {
        class JsonTask extends AsyncTask<URL, Void, ArrayList<MatchModel>> {

            @Override
            protected ArrayList<MatchModel> doInBackground(URL... urls) {
                ArrayList<MatchModel> matches = null;

                try {
                    //URL Json only text.
                    //URL url = new URL("https://api.myjson.com/bins/1eqw2d");
                    //URL Json text and images.
                    URL url = new URL("https://api.myjson.com/bins/gaenp");
                    // Create a new HTTP URL connection
                    URLConnection connection = url.openConnection();
                    HttpURLConnection httpConnection = (HttpURLConnection) connection;
                    int responseCode = httpConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream in = httpConnection.getInputStream();

                        // Parsear el flujo con formato JSON
                        GsonMatchParser parser = new GsonMatchParser();
                        matches = (ArrayList<MatchModel>) parser.readFlowJson(in);
                    }
                    else{
                        matches = new ArrayList<>();
                        matches.add(new MatchModel(null, null, null, null, null, null));
                    }
                    httpConnection.disconnect();
                } catch (MalformedURLException e) {
                    Log.e(TAG, "Malformed URL Exception.", e);
                } catch (IOException e) {
                    Log.e(TAG, "IO Exception.", e);
                }
             return matches;
            }

        @Override
        protected void onPostExecute(ArrayList<MatchModel> matches) {

            super.onPostExecute(matches);
            if(matches!=null) {
                matchesList.clear();

                for (int i = 0; i < matches.size(); i++) {
                    matchesList.add(matches.get(i));

                }
                adapterMatch.notifyDataSetChanged();
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
