package com.example.esb_2025;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MabaseSQLite extends SQLiteOpenHelper {

    public static final String DB_NAME = "userdb.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_USER = "user";

    public static final String COL_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_PWD = "pwd";
    public static final String COL_CIN = "cin";
    public static final String COL_FIRSTNAME = "firstname";
    public static final String COL_LASTNAME = "lastname";

    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_USERNAME + " TEXT, " +
                    COL_PWD + " TEXT, " +
                    COL_CIN + " TEXT, " +
                    COL_FIRSTNAME + " TEXT, " +
                    COL_LASTNAME + " TEXT);";

    public MabaseSQLite(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}

