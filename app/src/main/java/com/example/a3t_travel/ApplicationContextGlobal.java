package com.example.a3t_travel;
import android.app.Application;


public class ApplicationContextGlobal extends Application {
    private static int maTuyen;
    private static int maHoaDon;
    private  static int mTongTien;

    private static String ngayKhoiHanh;
    private static String tGian;
    private static int soLuongVe;
    private static String viTriGhe;

    private static int maThanhToan;
    private static String ptThanhToan;

    private static int maKhachHang;

    private static String hoTen;
    private static String sdt;
    private static String sdtXn;

    private static String diemLen;
    private static String diemXuong;

    public static String getDiemLen() {
        return diemLen;
    }

    public static void setDiemLen(String diemLen) {
        ApplicationContextGlobal.diemLen = diemLen;
    }

    public static String getDiemXuong() {
        return diemXuong;
    }

    public static void setDiemXuong(String diemXuong) {
        ApplicationContextGlobal.diemXuong = diemXuong;
    }

    public static String getSdtXn() {
        return sdtXn;
    }

    public static void setSdtXn(String sdtXn) {
        ApplicationContextGlobal.sdtXn = sdtXn;
    }

    private static ApplicationContextGlobal instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static ApplicationContextGlobal getInstance() {
        return instance;
    }

    public static String getHoTen() {
        return hoTen;
    }

    public static void setHoTen(String hoTen) {
        ApplicationContextGlobal.hoTen = hoTen;
    }

    public static String getSdt() {
        return sdt;
    }

    public static void setSdt(String sdt) {
        ApplicationContextGlobal.sdt = sdt;
    }

    public static int getmTongTien() {
        return mTongTien;
    }

    public static void setmTongTien(int mTongTien) {
        ApplicationContextGlobal.mTongTien = mTongTien;
    }

    public int getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(int maTuyen) {
        ApplicationContextGlobal.maTuyen = maTuyen;
    }

    public static int getMaHoaDon() {
        return maHoaDon;
    }

    public static void setMaHoaDon(int maHoaDon) {
        ApplicationContextGlobal.maHoaDon = maHoaDon;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        ApplicationContextGlobal.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String gettGian() {
        return tGian;
    }

    public void settGian(String tGian) {
        ApplicationContextGlobal.tGian = tGian;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        ApplicationContextGlobal.soLuongVe = soLuongVe;
    }

    public String getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(String viTriGhe) {
        ApplicationContextGlobal.viTriGhe = viTriGhe;
    }

    public static int getMaThanhToan() {
        return maThanhToan;
    }

    public static void setMaThanhToan(int maThanhToan) {
        ApplicationContextGlobal.maThanhToan = maThanhToan;
    }

    public String getPtThanhToan() {
        return ptThanhToan;
    }

    public void setPtThanhToan(String ptThanhToan) {
        ApplicationContextGlobal.ptThanhToan = ptThanhToan;
    }

    public static int getMaKhachHang() {
        return maKhachHang;
    }

    public static void setMaKhachHang(int maKhachHang) {
        ApplicationContextGlobal.maKhachHang = maKhachHang;
    }

    public static void setInstance(ApplicationContextGlobal instance) {
        ApplicationContextGlobal.instance = instance;
    }
}

