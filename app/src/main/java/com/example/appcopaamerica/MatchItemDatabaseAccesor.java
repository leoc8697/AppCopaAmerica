package com.example.appcopaamerica;

import android.arch.persistence.room.Room;
import android.content.Context;


public class MatchItemDatabaseAccesor {
    private static MatchItemDatabase MatchItemDatabaseInstance;
    //Constant about the name assigned to SQLite database
    private static final String TODO_DB_NAME = "matches_db";

    private MatchItemDatabaseAccesor() {
    }

    public static MatchItemDatabase getInstance(Context context) {
        if (MatchItemDatabaseInstance == null) {
// Create or open a new SQLite database, and return it as a Room Database instance.
            MatchItemDatabaseInstance = Room.databaseBuilder(context,
                    MatchItemDatabase.class, TODO_DB_NAME).build();
        }
        return MatchItemDatabaseInstance;
    }
}
