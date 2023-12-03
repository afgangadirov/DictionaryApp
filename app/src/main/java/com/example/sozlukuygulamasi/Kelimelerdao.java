package com.example.sozlukuygulamasi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Kelimelerdao {

    public void kelimeEkle(VeritabaniYardimcisi vt, String aze, String ing){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("aze",aze);
        degerler.put("ing",ing);

        dbx.insertOrThrow("kelimeler",null,degerler);
        dbx.close();

    }


    public ArrayList<Kelimeler> tumKelimeler (VeritabaniYardimcisi vt){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase dbx = vt.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler",null);

        while(c.moveToNext()){
            @SuppressLint("Range") Kelimeler kelime = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
            ,c.getString(c.getColumnIndex("aze"))
            ,c.getString(c.getColumnIndex("ing")));

            kelimelerArrayList.add(kelime);
        }

        return kelimelerArrayList;
    }



    public void kelimeSil(VeritabaniYardimcisi vt, int kelime_id){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        dbx.delete("kelimeler","kelime_id=?", new String[]{String.valueOf(kelime_id)});
        dbx.close();

    }

    public void kelimeGuncelle(VeritabaniYardimcisi vt, int kelime_id, String aze, String ing){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("aze",aze);
        degerler.put("ing",ing);

        dbx.update("kelimeler",degerler,"kelime_id=?", new String[]{String.valueOf(kelime_id)});
        dbx.close();

    }


    @SuppressLint("Range")
    public int kayitKontrol(VeritabaniYardimcisi vt){
        int sonuc = 0;
        SQLiteDatabase dbx = vt.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT count(*) as sonuc FROM kelimeler",null);

        while (c.moveToNext()){
            sonuc = c.getInt(c.getColumnIndex("sonuc"));
        }

        return sonuc;
    }


    @SuppressLint("Range")
    public Kelimeler kelimeleGetir(VeritabaniYardimcisi vt, int kelime_id){
        Kelimeler kelime = new Kelimeler();
        SQLiteDatabase dbx = vt.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler WHERE kelime_id ="+kelime_id,null);

        while (c.moveToNext()){
            Kelimeler k = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("aze"))
                    ,c.getString(c.getColumnIndex("ing")));

            kelime = k;

        }

        return kelime;
    }



    public ArrayList<Kelimeler> tumKelimelerRasgele3 (VeritabaniYardimcisi vt){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase dbx = vt.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler ORDER BY RANDOM() LIMIT 3",null);

        while(c.moveToNext()){
            @SuppressLint("Range") Kelimeler kelime = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("aze"))
                    ,c.getString(c.getColumnIndex("ing")));

            kelimelerArrayList.add(kelime);
        }

        return kelimelerArrayList;
    }





    public ArrayList<Kelimeler> kelimeAra (VeritabaniYardimcisi vt, String keyWord){
        ArrayList<Kelimeler> kelimelerArrayList = new ArrayList<>();
        SQLiteDatabase dbx = vt.getWritableDatabase();

        Cursor c = dbx.rawQuery("SELECT * FROM kelimeler WHERE ing LIKE '%"+keyWord+"%'",null);

        while(c.moveToNext()){
            @SuppressLint("Range") Kelimeler kelime = new Kelimeler(c.getInt(c.getColumnIndex("kelime_id"))
                    ,c.getString(c.getColumnIndex("aze"))
                    ,c.getString(c.getColumnIndex("ing")));

            kelimelerArrayList.add(kelime);
        }

        return kelimelerArrayList;
    }






}
