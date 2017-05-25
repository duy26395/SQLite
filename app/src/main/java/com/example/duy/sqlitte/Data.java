package com.example.duy.sqlitte;

/**
 * Created by duy on 23/05/2017.
 */

public class Data {
    private int id;
    private String Ten;
    private String Thanh_vien;

    public Data(int id, String ten, String thanh_vien) {
        this.id = id;
        Ten = ten;
        Thanh_vien = thanh_vien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getThanh_vien() {
        return Thanh_vien;
    }

    public void setThanh_vien(String thanh_vien) {
        Thanh_vien = thanh_vien;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", Ten='" + Ten + '\'' +
                ", Thanh_vien='" + Thanh_vien + '\'' +
                '}';
    }
}
