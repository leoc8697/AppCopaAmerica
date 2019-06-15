package com.example.appcopaamerica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TableFragment extends Fragment {

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

        //Aquí asignamos toda la info de nuestro recycler view en nuestro layout
        TableAdapterRecyclerView adapterTable= new TableAdapterRecyclerView(getTables(), R.layout.item_position, getActivity());
        recyclerViewTable.setAdapter(adapterTable);

        return view;
    }

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

}