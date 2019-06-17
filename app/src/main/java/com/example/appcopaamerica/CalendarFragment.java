package com.example.appcopaamerica;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CalendarFragment extends Fragment {

    ListView lista;
    ArrayAdapter adaptador;
    HttpURLConnection con;

    public CalendarFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar_fragment, container, false);

        //Vinculamos nuestra instancia recycler view
        RecyclerView recyclerViewMatch = (RecyclerView) view.findViewById(R.id.recyclerMatch);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewMatch.setLayoutManager(linearLayoutManager);

        //Aquí asignamos toda la info de nuestro recycler view en nuestro layout
        MatchAdapterRecyclerView adapterMatch= new MatchAdapterRecyclerView(getMatchs(), R.layout.item_match, getActivity());
        recyclerViewMatch.setAdapter(adapterMatch);

        return view;
    }

    public ArrayList<MatchModel> getMatchs(){

        ArrayList<MatchModel> matches = new ArrayList<>();
        matches.add(new MatchModel("Brasil", "Bolivia", "Hora", "   Viernes 14 Junio"));//, R.mipmap.brasil_round, R.mipmap.bolivia_round));
        matches.add(new MatchModel("Brasil2", "Bolivia2", "Hora2", "   Viernes2"));//, R.mipmap.brasil_round, R.mipmap.bolivia_round));
        //match.add(new MatchModel("Brasil3", "Hora3", "Bolivia3", "Viernes3",R.drawable.br,R.drawable.bo));

        return matches;
    }


    public class JsonTask extends AsyncTask<URL, Void, List<MatchModel>> {

        @Override
        protected List<MatchModel> doInBackground(URL... urls) {
            List<MatchModel> matches = null;

            try {

                // Establecer la conexión
                con = (HttpURLConnection)urls[0].openConnection();
                con.setConnectTimeout(15000);
                con.setReadTimeout(10000);

                // Obtener el estado del recurso
                int statusCode = con.getResponseCode();

                if(statusCode!=200) {
                    matches = new ArrayList<>();
                    matches.add(new MatchModel(null,null,null, null));

                } else {

                    // Parsear el flujo con formato JSON
                    InputStream in = new BufferedInputStream(con.getInputStream());

                    // JsonAnimalParser parser = new JsonAnimalParser();
                    GsonMatchParser parser = new GsonMatchParser();

                    matches = parser.readFlowJson(in);


                }

            } catch (Exception e) {
                e.printStackTrace();

            }finally {
                con.disconnect();
            }
            return matches;
        }

        @Override
        protected void onPostExecute(List<MatchModel> animales) {
            /*
            Asignar los objetos de Json parseados al adaptador
             */
            if(animales!=null) {
                adaptador = new MatchesAdapter((MainActivity) getContext(), animales);
                lista.setAdapter(adaptador);
            }else{
                Toast.makeText(
                        getContext(),
                        "Ocurrió un error de Parsing Json",
                        Toast.LENGTH_SHORT)
                        .show();
            }

        }
    }

}
