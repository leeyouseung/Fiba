package com.example.fiba.database.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.fiba.database.db_api.FindChildDao;
import com.example.fiba.database.table.FindChildDatabase;
import com.example.fiba.model.FindChild;

import java.util.List;

public class FindChildRepository {

    private FindChildDao findChildDao;
    private LiveData<List<FindChild>> allFindChild;

    public FindChildRepository(Application application) {

        FindChildDatabase database = FindChildDatabase.getInstance(application);

        findChildDao = database.findChildDao();
        allFindChild = findChildDao.getAllFindChild();
    }

    public void insert(FindChild findChild) {

        new InsertNoteAsyncTask(findChildDao).execute(findChild);
    }

    public void update(FindChild findChild) {

        new UpdateNoteAsyncTask(findChildDao).execute(findChild);
    }

    public void delete(FindChild findChild) {

        new DeleteNoteAsyncTask(findChildDao).execute(findChild);
    }

    public void deleteAllFindChild() {

        new DeleteAllNotesAsyncTask(findChildDao).execute();
    }

    public LiveData<List<FindChild>> getAllFindChild() {

        return allFindChild;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private InsertNoteAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildDao) {

            findChildDao.insert(notes[0]);

            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private UpdateNoteAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildDao) {

            findChildDao.update(notes[0]);

            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private DeleteNoteAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildDao) {

            findChildDao.delete([0]);

            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private DeleteAllNotesAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildDao) {

            findChildDao.deleteAllNote();

            return null;
        }
    }
}
