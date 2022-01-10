package com.mobilya.Model;

public class TedarikciModel {

    private int tedarikciID;
    private double borc, kredi, bakiye;
    private String tedarikciKodu, tedarikciAdi, lokasyon, telefon;

    public int getTedarikciID() {
        return tedarikciID;
    }

    public void setTedarikciID(int tedarikciID) {
        this.tedarikciID = tedarikciID;
    }

    public double getBorc() {
        return borc;
    }

    public void setBorc(double borc) {
        this.borc = borc;
    }

    public double getKredi() {
        return kredi;
    }

    public void setKredi(double kredi) {
        this.kredi = kredi;
    }

    public double getBakiye() {
        return bakiye;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public String getTedarikciKodu() {
        return tedarikciKodu;
    }

    public void setTedarikciKodu(String tedarikciKodu) {
        this.tedarikciKodu = tedarikciKodu;
    }

    public String getTedarikciAdi() {
        return tedarikciAdi;
    }

    public void setTedarikciAdi(String tedarikciAdi) {
        this.tedarikciAdi = tedarikciAdi;
    }

    public String getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(String lokasyon) {
        this.lokasyon = lokasyon;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
