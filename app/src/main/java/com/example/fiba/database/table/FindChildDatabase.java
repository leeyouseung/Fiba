package com.example.fiba.database.table;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.fiba.R;
import com.example.fiba.database.db_api.FindChildDao;
import com.example.fiba.model.FindChild;

@Database(entities = {FindChild.class}, version = 1)
public abstract class FindChildDatabase extends RoomDatabase {

    private static FindChildDatabase sInstance;

    public abstract FindChildDao findChildDao();

    public static synchronized FindChildDatabase getInstance(Context context) {

        if(sInstance == null) {

            sInstance = Room.databaseBuilder(context.getApplicationContext(), FindChildDatabase.class, "fiba_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return sInstance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbAsyncTask(sInstance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private FindChildDao findChildDao;

        private PopulateDbAsyncTask(FindChildDatabase db) {

            findChildDao = db.findChildDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            findChildDao.insert(new FindChild(R.drawable.child_image_find, "이재민", "남",
                    "대구소프트웨어고등학교 정문", "18", "160", "50",
                    "010-0000-0000", "안녕하세요"));

            findChildDao.insert(new FindChild(R.drawable.child_image_find, "김태빈", "남",
                    "대구소프트웨어고등학교 후문", "18", "165", "60",
                    "010-1234-1234", "우리 아이 좀 찾아주세요 ㅠㅠ"));

            findChildDao.insert(new FindChild(R.drawable.child_image_find, "곽현준", "남",
                    "대구소프트웨어고등학교 운동장", "18", "190", "90",
                    "010-1010-0101", "슬프네요"));

            return null;
        }
    }
}
