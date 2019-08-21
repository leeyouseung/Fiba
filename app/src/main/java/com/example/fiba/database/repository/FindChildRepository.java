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

        new InsertFindChildAsyncTask(findChildDao).execute(findChild);
    }

    public void update(FindChild findChild) {

        new UpdateFindChildAsyncTask(findChildDao).execute(findChild);
    }

    public void delete(FindChild findChild) {

        new DeleteFindChildAsyncTask(findChildDao).execute(findChild);
    }

    public void deleteAllFindChild() {

        new DeleteAllFindChildAsyncTask(findChildDao).execute();
    }

    public LiveData<List<FindChild>> getAllFindChild() {

        return allFindChild;
    }

    private static class InsertFindChildAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private InsertFindChildAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildren) {

            findChildDao.insert(findChildren[0]);

            return null;
        }
    }

    private static class UpdateFindChildAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private UpdateFindChildAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildren) {

            findChildDao.update(findChildren[0]);

            return null;
        }
    }

    private static class DeleteFindChildAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private DeleteFindChildAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildren) {

            findChildDao.delete(findChildren[0]);

            return null;
        }
    }

    private static class DeleteAllFindChildAsyncTask extends AsyncTask<FindChild, Void, Void> {

        private FindChildDao findChildDao;

        private DeleteAllFindChildAsyncTask(FindChildDao findChildDao) {

            this.findChildDao = findChildDao;
        }

        @Override
        protected Void doInBackground(FindChild... findChildren) {

            findChildDao.deleteAllFindChild();

            return null;
        }
    }
}
