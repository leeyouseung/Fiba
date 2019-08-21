package com.example.fiba.database.db_api;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fiba.model.FindChild;

import java.util.List;

@Dao
public interface FindChildDao {

    @Insert
    void insert(FindChild findChild);

    @Update
    void update(FindChild findChild);

    @Delete
    void delete(FindChild findChild);

    @Query("DELETE FROM find_child_table")
    void deleteAllFindChild();

    @Query("SELECT * FROM find_child_table ORDER BY childId DESC")
    LiveData<List<FindChild>> getAllFindChild();
}
