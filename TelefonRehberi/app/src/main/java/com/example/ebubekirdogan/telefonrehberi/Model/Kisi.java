package com.example.ebubekirdogan.telefonrehberi.Model;

/**
 * Created by EbubekirDogan on 12/22/2017.
 */

public class Kisi {

    private int id;
    private String AdveSoyad;
    private String Email;
    private String TelNo;
    private String Cinsiyet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdveSoyad() {
        return AdveSoyad;
    }

    public void setAdveSoyad(String adveSoyad) {
        AdveSoyad = adveSoyad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelNo() {
        return TelNo;
    }

    public void setTelNo(String telNo) {
        TelNo = telNo;
    }

    public String getCinsiyet() {
        return Cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        Cinsiyet = cinsiyet;
    }
}