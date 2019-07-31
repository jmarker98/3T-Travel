package com.example.a3t_travel.Entity;

import com.example.a3t_travel.ApplicationContextGlobal;

public class KhachHang extends ApplicationContextGlobal {
    int makhachhang;
    String tenkhachhang;
    String sodienthoai;
    String matkhau;

    public KhachHang(int makhachhang, String tenkhachhang, String sodienthoai, String matkhau) {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
        this.matkhau = matkhau;
    }

    public KhachHang() {
    }

    public int getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(int makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }
}
