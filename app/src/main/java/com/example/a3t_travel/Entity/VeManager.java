package com.example.a3t_travel.Entity;

import android.content.Intent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
public class VeManager {
    public ArrayList<Ve> listV = new ArrayList<>();

    public VeManager(String data) throws JSONException {
        JSONArray rootJSON = new JSONArray(data);

        for (int i = 0; i < rootJSON.length(); i++) {
            JSONObject ve = rootJSON.getJSONObject(i);

            int mave = Integer.parseInt(ve.getString("mave"));
            int mahoadon = Integer.parseInt(ve.getString("mahoadon"));
            String sodienthoai = ve.getString("sodienthoai");
            String ngaykhoihanh = ve.getString("ngaykhoihanh");
            String thoigian = ve.getString("thoigian");
            String vitrighe = ve.getString("vitrighe");

            Ve v = new Ve(mave, mahoadon, sodienthoai, ngaykhoihanh, thoigian, vitrighe);

            listV.add(v);
        }
    }
}
