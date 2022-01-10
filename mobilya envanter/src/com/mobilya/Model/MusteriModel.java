package com.mobilya.Model;

public class MusteriModel {

    private int musteriID;
    private String musteriKodu, adSoyad, location, telefon;
    private double borc, kredi, bakiye;

    public int getMusteriID() {
        return musteriID;
    }

    public void setMusteriID(int musteriID) {
        this.musteriID = musteriID;
    }

    public String getMusteriKodu() {
        return musteriKodu;
    }

    public void setMusteriKodu(String musteriKodu) {
        this.musteriKodu = musteriKodu;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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

}
