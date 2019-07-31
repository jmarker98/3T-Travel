package com.example.a3t_travel.Entity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class KhachHangManager {

    public ArrayList<KhachHang> listKH = new ArrayList<>();

    public KhachHangManager(String data) throws JSONException {

        JSONArray rootJSON = new JSONArray(data);

        for (int i = 0; i < rootJSON.length(); i++) {
            JSONObject khachhang = rootJSON.getJSONObject(i);

            int makhachhang = Integer.parseInt(khachhang.getString("makhachhang"));
            String tenkhachhang = khachhang.getString("tenkhachhang");
            String sodienthoai = khachhang.getString("sodienthoai");
            String matkhau = khachhang.getString("matkhau");

            KhachHang kh = new KhachHang(makhachhang, tenkhachhang, sodienthoai, matkhau);
            listKH.add(kh);
        }
    }
}
