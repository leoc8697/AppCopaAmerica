package com.example.appcopaamerica;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class JsonTeamParser {


    public List<TeamModel> readFlowJson(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return readArrayTeams(reader);
        } finally {
            reader.close();
        }

    }



    public List<TeamModel> readArrayTeams(JsonReader reader) throws IOException {
        // Lista temporal
        ArrayList<TeamModel> teams = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            // Leer objeto
            teams.add(readTeam(reader));
        }
        reader.endArray();
        return teams;
    }

    public TeamModel readTeam(JsonReader reader) throws IOException {
        // Variables locales
        String nameTeam = null;
        String flagTeam = null;

        // Iniciar objeto
        reader.beginObject();

        /*
        Lectura de cada atributo
         */
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "nameTeam":
                    nameTeam = reader.nextString();
                    break;
                case "flagTeam":
                    flagTeam = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new TeamModel(nameTeam, flagTeam);
    }

}
