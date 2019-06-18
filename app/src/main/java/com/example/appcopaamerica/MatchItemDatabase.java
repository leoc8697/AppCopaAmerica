package com.example.appcopaamerica;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MatchModelDb.class}, version = 1)
public abstract class MatchItemDatabase extends RoomDatabase {
    public abstract MatchItemDAO MatchItemDAO();
}
