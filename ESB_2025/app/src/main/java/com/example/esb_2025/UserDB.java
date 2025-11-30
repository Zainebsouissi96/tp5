package com.example.esb_2025;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDB {

    private MabaseSQLite maBaseSQLite;
    private SQLiteDatabase db;

    public UserDB(Context context) {
        maBaseSQLite = new MabaseSQLite(context);
    }

    public void open() {
        db = maBaseSQLite.getWritableDatabase();
    }

    public void close() {
        if (db != null && db.isOpen()) db.close();
    }

    // INSÉRER UN UTILISATEUR
    public long insertUser(User user) {
        ContentValues values = new ContentValues();
        values.put(MabaseSQLite.COL_USERNAME, user.getUsername());
        values.put(MabaseSQLite.COL_PWD, user.getPwd());
        values.put(MabaseSQLite.COL_CIN, user.getCin());
        values.put(MabaseSQLite.COL_FIRSTNAME, user.getFirstname());
        values.put(MabaseSQLite.COL_LASTNAME, user.getLastname());

        return db.insert(MabaseSQLite.TABLE_USER, null, values);
    }

    // VÉRIFIER LE LOGIN
    public boolean checkUser(String username, String pwd) {

        Cursor c = db.rawQuery(
                "SELECT * FROM " + MabaseSQLite.TABLE_USER +
                        " WHERE " + MabaseSQLite.COL_USERNAME + "=? AND " +





