package com.example.a3t_travel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3t_travel.Entity.KhachHangManager;
import com.example.a3t_travel.Entity.ResultEntity;

import org.json.JSONException;

public class Vecuatoi extends AppCompatActivity {
    ImageView vImgBack;
    TextView vDiemLen, vDiemXuong, vGhe, vGia, vNgay, vGio;
    Button vBtnHuy;
    ApplicationContextGlobal global = new ApplicationContextGlobal();
    ProgressDialog vPrD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vecuatoi);
        anhxa();

        vImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        vDiemLen.setText(global.getDiemLen());
        vDiemXuong.setText(global.getDiemXuong());
        vGhe.setText(global.getViTriGhe());
        vNgay.setText(global.getNgayKhoiHanh());
        vGio.setText(global.gettGian());
//        vGia.setText(global.getmTongTien());
        vPrD = new ProgressDialog(Vecuatoi.this);
        vPrD.setMessage("Vui lòng đợi trong chốc lát");
        vPrD.setCancelable(false);

        vBtnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void anhxa(){
        vBtnHuy = findViewById(R.id.btnHuyVe);
        vDiemLen = findViewById(R.id.txtdiemlen);
        vDiemXuong = findViewById(R.id.txtdiemxuong);
        vGhe = findViewById(R.id.vivtri);
//        vGia = findViewById(R.id.txtgiatien);
        vNgay = findViewById(R.id.ngayDi);
        vGio = findViewById(R.id.txtthoigian);
        vImgBack = findViewById(R.id.imgback);
    }
}
