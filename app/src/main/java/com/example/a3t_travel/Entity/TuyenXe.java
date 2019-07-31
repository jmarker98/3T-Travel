package com.example.a3t_travel.Entity;

import com.example.a3t_travel.ApplicationContextGlobal;

public class TuyenXe extends ApplicationContextGlobal {
    int maTuyen;
    String tenTuyen;
    float giaVe;

    public TuyenXe(int maTuyen, String tenTuyen, float giaVe) {
        this.maTuyen = maTuyen;
        this.tenTuyen = tenTuyen;
        this.giaVe = giaVe;
    }

    public int getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(int maTuyen) {
        this.maTuyen = maTuyen;
    }

    public String getTenTuyen() {
        return tenTuyen;
    }

    public void setTenTuyen(String tenTuyen) {
        this.tenTuyen = tenTuyen;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }
}
