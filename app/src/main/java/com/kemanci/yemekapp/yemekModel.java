package com.kemanci.yemekapp;

import android.graphics.drawable.Drawable;

import java.util.List;

public class yemekModel {

    private String yemekAdi;
    private String suresi;
    private String kackisi;
    private String tarif;
    private String image;
    public Drawable _drawable;

    private List<malzeme> malzemeler;

    public yemekModel(String yemekAdi, String suresi, String kackisi, String tarif, String image, List<malzeme> malzemeler) {
        this.yemekAdi = yemekAdi;
        this.suresi = suresi;
        this.kackisi = kackisi;
        this.tarif = tarif;
        this.image = image;
        this.malzemeler = malzemeler;
    }

    public String getYemekAdi() {
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public String getSuresi() {
        return suresi;
    }

    public void setSuresi(String suresi) {
        this.suresi = suresi;
    }

    public String getKackisi() {
        return kackisi;
    }

    public void setKackisi(String kackisi) {
        this.kackisi = kackisi;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<malzeme> getMalzemeler() {
        return malzemeler;
    }

    public void setMalzemeler(List<malzeme> malzemeler) {
        this.malzemeler = malzemeler;
    }
}

class malzeme{
    public String birim;
    public String miktar;
    public String malzemeAdi;


    public malzeme(String birim,String miktar,String malzemeAdi){
        this.birim=birim;
        this.malzemeAdi=malzemeAdi;
        this.miktar=miktar;
    }
}