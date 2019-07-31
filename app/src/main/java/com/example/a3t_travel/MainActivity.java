package com.example.a3t_travel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(!checkConnect(MainActivity.this)) builder(MainActivity.this).show();
        else {
            setContentView(R.layout.activity_main);
            Thread th = new Thread(wait);
            th.start();
        }
    }

    Runnable wait = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);

                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    public boolean checkConnect(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null & mobile.isConnectedOrConnecting()) || (wifi != null & wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }

    public AlertDialog.Builder builder(Context c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("Không có kết nối");
        builder.setMessage("Bạn cần có kết nối 3G hoặc wifi để tiếp tục. Nhấn Ok để thoát!");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        return builder;
    }
}
