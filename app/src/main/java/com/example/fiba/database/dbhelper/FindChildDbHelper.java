package com.example.fiba.database.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fiba.database.dbcolumns.FindChildDbColumns;

public class FindChildDbHelper extends SQLiteOpenHelper {

    private static FindChildDbHelper sInstance;

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "FindChild.db";

    private static final String SQL_FIND_CHILD_CREATE_ENTRIES =
            String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                    FindChildDbColumns.FindChildEntry.TABLE_NAME,
                    FindChildDbColumns.FindChildEntry._ID,
                    FindChildDbColumns.FindChildEntry.CLUAMN_NAME_FIND_CHILD_NAME,
                    FindChildDbColumns.FindChildEntry.CLUAMN_NAME_FIND_CHILD_SEX,
                    FindChildDbColumns.FindChildEntry.CLUAMN_NAME_FIND_CHILD_AGE,
                    FindChildDbColumns.FindChildEntry.CLUAMN_NAME_LOST_PLACE,
                    FindChildDbColumns.FindChildEntry.CLUAMN_NAME_FIND_CHILD_HEIGHT,
                    FindChildDbColumns.FindChildEntry.CLUAMN_NAME_FIND_CHILD_WEIGHT );

    private static final String SQL_FIND_CHILD_DELETE_ENTRIES =
            String.format("DROP TABLE IF EXISTS " + FindChildDbColumns.FindChildEntry.TABLE_NAME);

    public static FindChildDbHelper getInstance(Context context) {

        if(sInstance == null) {

            sInstance = new FindChildDbHelper(context);
        }

        return sInstance;
    }

    private FindChildDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_FIND_CHILD_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_FIND_CHILD_DELETE_ENTRIES);

        onCreate(db);
    }
}
