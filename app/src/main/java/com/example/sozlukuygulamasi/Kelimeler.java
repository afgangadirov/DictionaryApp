package com.example.sozlukuygulamasi;

public class Kelimeler {
    private int kelime_id;
    private String aze;
    private String ing;

    public Kelimeler() {
    }

    public Kelimeler(int kelime_id, String aze, String ing) {
        this.kelime_id = kelime_id;
        this.aze = aze;
        this.ing = ing;
    }

    public int getKelime_id() {
        return kelime_id;
    }

    public void setKelime_id(int kelime_id) {
        this.kelime_id = kelime_id;
    }

    public String getAze() {
        return aze;
    }

    public void setAze(String aze) {
        this.aze = aze;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }
}
