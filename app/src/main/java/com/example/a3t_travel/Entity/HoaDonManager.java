package com.example.a3t_travel.Entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HoaDonManager {


    public ArrayList<HoaDon> listHD = new ArrayList<>();

    public HoaDonManager(String data) throws JSONException {
        JSONArray rootJSON = new JSONArray(data);

        for (int i = 0; i < rootJSON.length(); i++) {

            JSONObject hoadon = rootJSON.getJSONObject(i);

            int mahoadon = Integer.parseInt(hoadon.getString("mahoadon"));
            int makhachhang = Integer.parseInt(hoadon.getString("makhachhang"));
            int mathanhtoan = Integer.parseInt(hoadon.getString("mathanhtoan"));
            int matuyen = Integer.parseInt(hoadon.getString("matuyen"));
            int soluongve = Integer.parseInt(hoadon.getString("soluongve"));
            int thanhtien = Integer.parseInt(hoadon.getString("thanhtien"));

            HoaDon hd = new HoaDon(mahoadon, makhachhang, mathanhtoan, matuyen, soluongve, thanhtien);

            listHD.add(hd);
        }
    }

}
