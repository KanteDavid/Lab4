package com.david.lab4;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class myDbHelper extends SQLiteOpenHelper {
    public myDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE IF NOT EXISTS clients (id integer primary key autoincrement, nom text,prenom text,adresse text, user text, pw text, solde integer, credit integer);";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String query = "DROP TABLE If EXISTS clients;";
        db.execSQL(query);
        onCreate(db);
    }
}
