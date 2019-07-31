package com.example.a3t_travel;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private final String TAG = getClass().getName();


    /**
     * Hàm gửi request tới máy chủ
     *
     * @param typeRequest Kiểu gửi: 1-GET | 2-POST
     * @param url         Liên kết tới máy chủ
     * @param param       Tham số
     * @return Dữ liệu text trả về từ máy chủ
     */

    public String sendRequest(int typeRequest, String url, String param[][]) {
        String result = null;
        try {
            switch ((typeRequest)) {
                case 1:
                    result = sendRequestGET(url, param);
                    break;
                case 2:
                    result = sendRequestPOST(url, param);
                    break;
            }
        } catch (IOException ioe) {
            Log.e(this.getClass().getName() + "Loi nhap xuat", ioe.toString());
            ioe.printStackTrace();
        } catch (Exception ex) {
            Log.e(this.getClass().getName() + "Loi he thong", ex.toString());
            ex.printStackTrace();
        }
        return result;

    }

    //phuong thuc GET

    private String sendRequestGET(String url, String param[][]) throws IOException {
        //chuan bi du lieu
        StringBuilder urlParams = new StringBuilder(url + "?");
        for (int i = 0; i < param.length; i++) {
            if (i == 0) {
                urlParams.append(param[i][0] + "=" + URLEncoder.encode(param[i][1], "UTF-8"));

            } else {
                urlParams.append("&" + param[i][0] + "=" + URLEncoder.encode(param[i][1], "UTF-8"));
            }
        }
        //duong dan gui du lieu
        Log.e(TAG, urlParams.toString());
        URL link = new URL(urlParams.toString());

        //1. gui du lieu get data
        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(15000);
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //gui
        connection.connect();
        Log.e(TAG, "Gui thanh cong");

        //2. nhan phan hoi tu request
        return getRespose(connection);


    }


    //Phuong thuc POST

    private String sendRequestPOST(String url, String param[][]) throws IOException {
        URL link = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) link.openConnection();
        conn.setReadTimeout(10000);     // Read Timeout = 10s
        conn.setConnectTimeout(15000);  // Connect Timeout = 15s
        conn.setRequestMethod("POST");  // Phương thức gửi dữ liệu là POST
        conn.setDoInput(true);          // Cho phép nhận dữ liệu
        conn.setDoOutput(true);         // Cho phép gửi dữ liệu

        // Chuẩn bị tham số
        HashMap<String, String> postDataParams = new HashMap<>();
        for (int i = 0; i < param.length; i++) {
            postDataParams.put(param[i][0], param[i][1]);
        }

        // Gửi dữ liệu POST
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        writer.write(getPostDataString(postDataParams));
        writer.flush();
        writer.close();
        os.close();

        // Gửi
        conn.connect();

        // Nhận dữ liệu phản hồi
        return getRespose(conn);


    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return result.toString();
    }

    private String getRespose(HttpURLConnection connection) throws IOException {
        //Nhan phan hoi tu server
        BufferedReader bufferedReader = new
                BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        //doc tung hang trong server

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        bufferedReader.close(); //dong
        return stringBuilder.toString();

    }
}
