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

public class TableFragment extends Fragment {

    ArrayList<TableModel> tablesList = new ArrayList<>();
    TableAdapterRecyclerView adapterTable;

    public TableFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);

        //Vinculamos nuestra instancia recycler view
        RecyclerView recyclerViewTable = (RecyclerView) view.findViewById(R.id.recyclerPosition);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewTable.setLayoutManager(linearLayoutManager);

        getTableParsed();

        //Aquí asignamos toda la info de nuestro recycler view en nuestro layout
        adapterTable = new TableAdapterRecyclerView(tablesList, R.layout.item_position, getActivity(), getActivity().getApplicationContext());
        recyclerViewTable.setAdapter(adapterTable);

        return view;
    }
/*
    public ArrayList<TableModel> getTables(){

        ArrayList<TableModel> tables = new ArrayList<>();

        tables.add(new TableModel("  Grupo A", "1.", "2.", "3.",
                "4.", "Primero", "Segundo", "Tercero", "Cuarto",
                "3", "2", "2", "2", "10:1", "7:3", "4:4", "1:8", "+9",
                "+4", "0","-7", "9", "6", "3", "0", R.mipmap.brasil_round,
                R.mipmap.peru_round, R.mipmap.chile_round, R.mipmap.uruguay_round));

        tables.add(new TableModel("  Grupo B", "1.", "2.", "3.",
                "4.", "Primero", "Segundo", "Tercero", "Cuarto",
                "3", "2", "2", "2", "10:1", "7:3", "4:4", "1:8", "+9",
                "+4", "0","-7", "9", "6", "3", "0", R.mipmap.colombia_round,
                R.mipmap.argentina_round, R.mipmap.qatar_round, R.mipmap.paraguay_round));

        return tables;
    }
    */


    private void getTableParsed()

    {
        class JsonTask extends AsyncTask<URL, Void, ArrayList<TableModel>> {

            @Override
            protected ArrayList<TableModel> doInBackground(URL... urls) {
                ArrayList<TableModel> tables = null;

                try {
                    //URL Json only text.
                    //URL url = new URL("https://api.myjson.com/bins/1eqw2d");
                    //URL Json text and images.
                    URL url = new URL("https://api.myjson.com/bins/1admst");
                    // Create a new HTTP URL connection
                    URLConnection connection = url.openConnection();
                    HttpURLConnection httpConnection = (HttpURLConnection) connection;
                    int responseCode = httpConnection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        InputStream in = httpConnection.getInputStream();

                        // Parsear el flujo con formato JSON
                        GsonTableParser parser = new GsonTableParser();
                        tables = (ArrayList<TableModel>) parser.readFlowJson(in);
                    }
                    else{
                        tables = new ArrayList<>();
                        tables.add(new TableModel(null, null, null, null, null,
                                null, null,null, null,
                                null,null,null,null,null,null,null,null,
                                null,null,null,null,null,null,null,null,
                                null,null,null,null));
                    }
                    httpConnection.disconnect();
                } catch (MalformedURLException e) {
                    Log.e(TAG, "Malformed URL Exception.", e);
                } catch (IOException e) {
                    Log.e(TAG, "IO Exception.", e);
                }
                return tables;
            }

            @Override
            protected void onPostExecute(ArrayList<TableModel> tables) {

                super.onPostExecute(tables);
                if(tables!=null) {
                    tablesList.clear();

                    for (int i = 0; i < tables.size(); i++) {
                        tablesList.add(tables.get(i));

                    }
                    adapterTable.notifyDataSetChanged();
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