package com.mobilya.Model;

public class UrunModel {

    private int urunID, miktar, kullaniciID;
    private double maliyetFiyati, satisFiyati;
    private Double toplamTutar, toplamGelir;
    private String urunKodu, urunAdi, tarih, tedarikciKodu, musteriKodu, musteriAdi, marka;

    public int getUrunID() {
        return urunID;
    }

    public void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public int getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(int kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public double getMaliyetFiyati() {
        return maliyetFiyati;
    }

    public void setMaliyetFiyati(double maliyetFiyati) {
        this.maliyetFiyati = maliyetFiyati;
    }

    public double getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(double satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public Double getToplamTutar() {
        return toplamTutar;
    }

    public void setToplamTutar(Double toplamTutar) {
        this.toplamTutar = toplamTutar;
    }

    public Double getToplamGelir() {
        return toplamGelir;
    }

    public void setToplamGelir(Double toplamGelir) {
        this.toplamGelir = toplamGelir;
    }

    public String getUrunKodu() {
        return urunKodu;
    }

    public void setUrunKodu(String urunKodu) {
        this.urunKodu = urunKodu;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getTedarikciKodu() {
        return tedarikciKodu;
    }

    public void setTedarikciKodu(String tedarikciKodu) {
        this.tedarikciKodu = tedarikciKodu;
    }

    public String getMusteriKodu() {
        return musteriKodu;
    }

    public void setMusteriKodu(String musteriKodu) {
        this.musteriKodu = musteriKodu;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }
}
