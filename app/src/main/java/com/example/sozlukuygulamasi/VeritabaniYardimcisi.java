package com.example.sozlukuygulamasi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VeritabaniYardimcisi extends SQLiteOpenHelper {
    public VeritabaniYardimcisi(@Nullable Context context) {
        super(context, "sozluk", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"kelimeler\" (\n" +
                "\t\"kelime_id\"\tINTEGER,\n" +
                "\t\"aze\"\tTEXT,\n" +
                "\t\"ing\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"kelime_id\" AUTOINCREMENT)\n" +
                ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS kelimeler ");
        onCreate(db);

    }
}
