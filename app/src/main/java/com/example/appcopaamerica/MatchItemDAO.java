package com.example.appcopaamerica;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface MatchItemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMatchItems(List<MatchModelDb> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMatchItem(MatchModelDb item);

    @Update
    public void updateMatchItem(MatchModelDb item);

    @Delete
    public void deleteMatchItem(MatchModelDb item);

    @Query("SELECT * FROM MatchModelDb  ORDER BY id DESC")
    public List<MatchModelDb> loadAllItems();
}
