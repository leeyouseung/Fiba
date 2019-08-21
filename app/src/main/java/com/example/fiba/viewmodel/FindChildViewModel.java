package com.example.fiba.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.fiba.database.repository.FindChildRepository;
import com.example.fiba.model.FindChild;

import java.util.List;

public class FindChildViewModel extends AndroidViewModel {

    private FindChildRepository repository;
    private LiveData<List<FindChild>> allFindchild;

    public FindChildViewModel(@NonNull Application application) {
        super(application);

        repository = new FindChildRepository(application);
        allFindchild = repository.getAllFindChild();
    }

    public void insert(FindChild findChild) {

        repository.insert(findChild);
    }

    public void update(FindChild findChild) {

        repository.update(findChild);
    }

    public void delete(FindChild findChild) {

        repository.delete(findChild);
    }

    public void deleteAllNotes() {

        repository.deleteAllFindChild();
    }

    public LiveData<List<FindChild>> getAllFindChild() {

        return allFindchild;
    }
}
