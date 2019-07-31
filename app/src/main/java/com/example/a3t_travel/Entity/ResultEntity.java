package com.example.a3t_travel.Entity;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ResultEntity {
    int id;
    String message;

    public ResultEntity(String data) throws JSONException {
        try {
            JSONObject rootJSON = new JSONObject(data);
            this.id = rootJSON.getInt("id");
            this.message = rootJSON.getString("message");
        } catch (Exception ex) {
            Log.e(getClass().getName(), "Loi he thong");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
