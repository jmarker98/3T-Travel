package com.example.a3t_travel.Entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TuyenXeManager {
    public ArrayList<TuyenXe> listTX = new ArrayList<>();

    public TuyenXeManager(String data) throws JSONException {
        JSONArray rootJSON = new JSONArray(data);

        for (int i = 0; i < rootJSON.length(); i++) {
            JSONObject tuyenxe = rootJSON.getJSONObject(i);

            int matuyen = Integer.parseInt(tuyenxe.getString("matuyen"));
            String tentuyen = tuyenxe.getString("tentuyen");
            float giave = Float.parseFloat(tuyenxe.getString("giave"));

            TuyenXe tx = new TuyenXe(matuyen, tentuyen, giave);
            listTX.add(tx);
        }
    }
}
