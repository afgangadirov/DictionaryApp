package com.example.sozlukuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private VeritabaniYardimcisi vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vt = new VeritabaniYardimcisi(this);

        /*new Kelimelerdao().kelimeEkle(vt,"qol","arm");
        new Kelimelerdao().kelimeEkle(vt,"papaq","hat");
        new Kelimelerdao().kelimeEkle(vt,"pencere","window");
        new Kelimelerdao().kelimeEkle(vt,"qulaqliq","headphone");
        new Kelimelerdao().kelimeEkle(vt,"divar","wall");*/

        //new Kelimelerdao().kelimeSil(vt,3);

        //new Kelimelerdao().kelimeGuncelle(vt,1,"ayaq","foot");


        int gelenSonuc = new Kelimelerdao().kayitKontrol(vt);
        Log.e("Verilen sayi",String.valueOf(gelenSonuc));


        Kelimeler gelenKelime = new Kelimelerdao().kelimeleGetir(vt,4);
        Log.e("Kelime",gelenKelime.getKelime_id()+" - "+gelenKelime.getAze()+" - "+gelenKelime.getIng());


        ArrayList<Kelimeler> gelenKelimelerListesi = new Kelimelerdao().kelimeAra(vt,"ea");

        for (Kelimeler k: gelenKelimelerListesi) {
            Log.e(String.valueOf(k.getKelime_id()),k.getAze()+" - "+k.getIng());

        }

    }
}