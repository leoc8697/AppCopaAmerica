package com.example.appcopaamerica;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class JsonTableParser {


    public List<TableModel> readFlowJson(InputStream in) throws IOException {
        // Nueva instancia JsonReader
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            // Leer Array
            return readArrayMatches(reader);
        } finally {
            reader.close();
        }

    }



    public List<TableModel> readArrayMatches(JsonReader reader) throws IOException {
        // Lista temporal
        ArrayList<TableModel> tables = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            // Leer objeto
            tables.add(readTable(reader));
        }
        reader.endArray();
        return tables;
    }

    public TableModel readTable(JsonReader reader) throws IOException {
        // Variables locales

        String nameGroup = null;
        String position1 = null;
        String position2 = null;
        String position3 = null;
        String position4 = null;
        String namePosition1 = null;
        String namePosition2 = null;
        String namePosition3 = null;
        String namePosition4 = null;
        String pj1 = null;
        String pj2 = null;
        String pj3 = null;
        String pj4 = null;
        String goals1 = null;
        String goals2 = null;
        String goals3 = null;
        String goals4 = null;
        String difGoal1 = null;
        String difGoal2 = null;
        String difGoal3 = null;
        String difGoal4 = null;
        String pts1 = null;
        String pts2 = null;
        String pts3 = null;
        String pts4 = null;
        String imgPos1 = null;
        String imgPos2 = null;
        String imgPos3 = null;
        String imgPos4 = null;

        // Iniciar objeto
        reader.beginObject();

        /*
        Lectura de cada atributo
         */
        while (reader.hasNext()) {
            String name = reader.nextName();
            switch (name) {
                case "nameGroup":
                nameGroup = reader.nextString();
                break;
                case "position1":
                    position1 = reader.nextString();
                    break;
                case "position2":
                    position2 = reader.nextString();
                    break;
                case "position3":
                    position3 = reader.nextString();
                    break;
                case "position4":
                    position4 = reader.nextString();
                    break;
                case "namePosition1":
                    namePosition1 = reader.nextString();
                    break;
                case "namePosition2":
                    namePosition2 = reader.nextString();
                    break;
                case "namePosition3":
                    namePosition3 = reader.nextString();
                    break;
                case "namePosition4":
                    namePosition4 = reader.nextString();
                    break;
                case "pj1":
                    pj1 = reader.nextString();
                    break;
                case "pj2":
                    pj2 = reader.nextString();
                    break;
                case "pj3":
                    pj3 = reader.nextString();
                    break;
                case "pj4":
                    pj4 = reader.nextString();
                    break;
                case "goals1":
                    goals1 = reader.nextString();
                    break;
                case "goals2":
                    goals2 = reader.nextString();
                    break;
                case "goals3":
                    goals3 = reader.nextString();
                    break;
                case "goals4":
                    goals4 = reader.nextString();
                    break;
                case "difGoal1":
                    difGoal1 = reader.nextString();
                    break;
                case "difGoal2":
                    difGoal2 = reader.nextString();
                    break;
                case "difGoal3":
                    difGoal3 = reader.nextString();
                    break;
                case "difGoal4":
                    difGoal4 = reader.nextString();
                    break;
                case "pts1":
                    pts1 = reader.nextString();
                    break;
                case "pts2":
                    pts2 = reader.nextString();
                    break;
                case "pts3":
                    pts3 = reader.nextString();
                    break;
                case "pts4":
                    pts4 = reader.nextString();
                    break;
                case "imgPos1":
                    imgPos1 = reader.nextString();
                    break;
                case "imgPos2":
                    imgPos2 = reader.nextString();
                    break;
                case "imgPos3":
                    imgPos3 = reader.nextString();
                    break;
                case "imgPos4":
                    imgPos4 = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new TableModel(nameGroup, position1, position2,position3, position4, namePosition1, namePosition2, namePosition3,
                namePosition4, pj1, pj2, pj3, pj4, goals1, goals2, goals3, goals4, difGoal1, difGoal2, difGoal3, difGoal4,
                pts1, pts2, pts3, pts4, imgPos1, imgPos2, imgPos3, imgPos4);

    }

}
