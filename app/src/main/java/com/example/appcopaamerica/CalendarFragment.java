package com.example.appcopaamerica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CalendarFragment extends Fragment {


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
        matches.add(new MatchModel("Brasil", "Bolivia", "Hora", "  Viernes 14 Junio", R.mipmap.brasil_round, R.mipmap.bolivia_round));
        matches.add(new MatchModel("Brasil2", "Bolivia2", "Hora2", "  Viernes2", R.mipmap.brasil_round, R.mipmap.bolivia_round));
        //match.add(new MatchModel("Brasil3", "Hora3", "Bolivia3", "Viernes3",R.drawable.br,R.drawable.bo));

        return matches;
    }

}
