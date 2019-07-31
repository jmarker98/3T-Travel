package com.example.a3t_travel.Entity;

import com.example.a3t_travel.ApplicationContextGlobal;

public class Ve extends ApplicationContextGlobal {
    int maVe;
    int maHoaDon;
    String soDienThoai;
    String ngayKhoiHanh;
    String thoiGian;
    String viTriGhe;

    public Ve(int maVe, int maHoaDon, String soDienThoai, String ngayKhoiHanh, String thoiGian, String viTriGhe) {
        this.maVe = maVe;
        this.maHoaDon = maHoaDon;
        this.soDienThoai = soDienThoai;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.thoiGian = thoiGian;
        this.viTriGhe = viTriGhe;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public int getMaTuyen() {
        return maHoaDon;
    }

    public void setMaTuyen(int maTuyen) {
        this.maHoaDon = maTuyen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(String viTriGhe) {
        this.viTriGhe = viTriGhe;
    }
}
