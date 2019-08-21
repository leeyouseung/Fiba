package com.example.fiba.database.db_api;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.fiba.model.FindChild;

@Dao
public interface FindChildDao {

    @Insert
    void insert(FindChild findChild);
}
