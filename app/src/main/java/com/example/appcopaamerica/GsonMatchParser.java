package com.example.appcopaamerica;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GsonMatchParser {


    public List<MatchModel> readFlowJson(InputStream in) throws IOException {
        // Nueva instancia de la clase Gson
        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        List<MatchModel> animales = new ArrayList<>();

        // Iniciar el array
        reader.beginArray();

        while (reader.hasNext()) {
            // Lectura de objetos
            MatchModel animal = gson.fromJson(reader, MatchModel.class);
            animales.add(animal);
        }


        reader.endArray();
        reader.close();
        return animales;
    }
}