package com.example.appcopaamerica;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por Hermosa Programación.
 */
public class JsonMatchParser {


    public List<MatchModel> readFlowJson(InputStream in) throws IOException {
        // Nueva instancia JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return readArrayMatches(reader);
        } finally {
            reader.close();
        }

    }



    public List<MatchModel> readArrayMatches(JsonReader reader) throws IOException {
        // Lista temporal
        ArrayList<MatchModel> matches = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            // Leer objeto
            matches.add(readMatch(reader));
        }
        reader.endArray();
        return matches;
    }

    public MatchModel readMatch(JsonReader reader) throws IOException {
        // Variables locales
        String team1 = null;
        String team2 = null;
        String score = null;
        String dateMatch = null;

        // Iniciar objeto
        reader.beginObject();

        /*
        Lectura de cada atributo
         */
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "team1":
                    team1 = reader.nextString();
                    break;
                case "team2":
                    team2 = reader.nextString();
                    break;
                case "score":
                    score = reader.nextString();
                    break;
                case "dateMatch":
                    dateMatch = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new MatchModel(team1, team2, score, dateMatch);
    }

}

