package com.example.a3t_travel.Menu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a3t_travel.ApplicationContextGlobal;
import com.example.a3t_travel.Constant;
import com.example.a3t_travel.Entity.KhachHangManager;
import com.example.a3t_travel.Entity.ResultEntity;
import com.example.a3t_travel.Login;
import com.example.a3t_travel.Main2Activity;
import com.example.a3t_travel.R;
import com.example.a3t_travel.Server;

import org.json.JSONException;

public class activity_thongtinkhachhang extends AppCompatActivity {
    EditText ttEdtHoten, ttEdtSdt;
    ImageView ttImgBack;
    Button ttBtnThaydoi;
    ProgressDialog ttPrD;
    Server server = new Server();

    Runnable taskUpdate = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ttPrD.show();
                }
            });
            String hoten = getDataForm(R.id.editHoten);
            String sdt = getDataForm(R.id.editSdt);
            String data1[][] = {
                    {"tenkhachhang", hoten},
                    {"sodienthoai", sdt}};

            final String result = server.sendRequest(2,
                    Constant.HOSTING_API + Constant.PAGE_UPDATE, data1);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ttPrD.dismiss();
                    ResultEntity resultEntity = null;
                    try {
                        resultEntity = new ResultEntity(result);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (resultEntity == null) {
                        Log.e("3T Team", "Thành công !!");
                    }
                    Toast.makeText(activity_thongtinkhachhang.this,
                            "Cập nhật " + resultEntity.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
    private String getDataForm(int resource) {
        EditText text = (EditText) findViewById(resource);
        return text.getText().toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinkhachhang);
        ttEdtHoten = findViewById(R.id.editHoten);
        ttEdtSdt = findViewById(R.id.editSdt);
        ttBtnThaydoi = findViewById(R.id.btnThaydoi);
        ttImgBack = findViewById(R.id.imgback);

        ttEdtSdt.setEnabled(false);
        ttEdtSdt.setText(ApplicationContextGlobal.getSdt());


        ttPrD = new ProgressDialog(activity_thongtinkhachhang.this);
        ttPrD.setMessage("Vui lòng đợi trong chốc lát");
        ttPrD.setCancelable(false);

        ttImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ttBtnThaydoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chạy runTime đẩy dữ liệu lên server
                if (ttEdtHoten.getText().length() < 1) {
                    Toast.makeText(activity_thongtinkhachhang.this, "Không được để trống họ tên !!", Toast.LENGTH_SHORT).show();
                } else {

                    Thread th = new Thread(taskUpdate);
                    th.start();
                    ApplicationContextGlobal.setHoTen(ttEdtHoten.getText().toString());
                    finish();
                }

            }
        });
    }
}