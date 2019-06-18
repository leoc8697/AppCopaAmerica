package com.example.appcopaamerica;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GsonTeamParser {


    public List<TeamModel> readFlowJson(InputStream in) throws IOException {
        // Nueva instancia de la clase Gson
        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        List<TeamModel> teams = new ArrayList<>();

        // Iniciar el array
        reader.beginArray();

        while (reader.hasNext()) {
            // Lectura de objetos
            TeamModel team = gson.fromJson(reader, TeamModel.class);
            teams.add(team);
        }

        reader.endArray();
        reader.close();
        return teams;
    }
}
