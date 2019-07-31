package com.example.a3t_travel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3t_travel.Entity.HoaDon;
import com.example.a3t_travel.Entity.HoaDonManager;
import com.example.a3t_travel.Entity.KhachHangManager;
import com.example.a3t_travel.Entity.ResultEntity;
import com.example.a3t_travel.Menu.activity_thongtinkhachhang;

import org.json.JSONException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class XacNhanThongTin extends AppCompatActivity {
    Button xnBtnChinhSua, xnBtnDatVe;
    TextView xnTxtTongTien, xnTxtGhe, xnTxtSdt, xnTxtDiemDon, xnTxtDiemXuong, xnTxtNgayDi, xnTxtGioDi;
    ApplicationContextGlobal global = new ApplicationContextGlobal();
    ProgressDialog xnPrD;
    Server server = new Server();
    int maHD;


    Runnable taskLog = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    xnPrD.show(); // Bật dialog progress
                }
            });

            final int makh = global.getMaKhachHang();

            String data[][] = {
                    {"makhachhang", String.valueOf(makh)}
            };
            final String result = server.sendRequest(1,
                    Constant.HOSTING_API + Constant.PAGE_SELECTHD, data);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    xnPrD.dismiss(); // Tắt dialog progress
                    try {
                        HoaDonManager manager = new HoaDonManager(result);
                        // Nếu đăng nhập sai
                        if (manager.listHD.size() == 0) {
                            Toast.makeText(XacNhanThongTin.this, "Kết thúc phiên làm việc !", Toast.LENGTH_SHORT).show();
                        } else {
                            //luu ma khach hang cung phien lam viec.
                            maHD = (manager.listHD.get(0).getMaHoaDon());
                            Thread thread = new Thread(taskReg);
                            thread.start();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    };


    Runnable taskReg = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    xnPrD.show();
                }
            });
            int mahd = maHD;
            String sdt = xnTxtSdt.getText().toString();
            String ngaydi = xnTxtNgayDi.getText().toString();
            String tg = xnTxtGioDi.getText().toString();
            String vitri = xnTxtGhe.getText().toString();

            String data[][] = {
                    {"mahoadon", String.valueOf(mahd)},
                    {"sodienthoai", sdt},
                    {"ngaykhoihanh", ngaydi},
                    {"thoigian", tg},
                    {"vitrighe", vitri}

            };
            final String result = server.sendRequest(1,
                    Constant.HOSTING_API + Constant.PAGE_CONFIRM, data);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    xnPrD.dismiss();
                    ResultEntity resultEntity = null;
                    try {
                        resultEntity = new ResultEntity(result);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (resultEntity == null) {
                        Log.e("3T Team", "Thành công !!");
                    }
                    finish();
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xac_nhan_thong_tin);
        anhxa();

        xnPrD = new ProgressDialog(XacNhanThongTin.this);
        xnPrD.setMessage("Vui lòng đợi trong chốc lát");
        xnPrD.setCancelable(false);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            xnTxtGhe.setText(bundle.getString("ghe"));
            xnTxtSdt.setText(bundle.getString("sdt"));
            xnTxtDiemDon.setText(bundle.getString("len"));
            xnTxtDiemXuong.setText(bundle.getString("xuong"));
            xnTxtNgayDi.setText(bundle.getString("ngay"));
            xnTxtGioDi.setText(bundle.getString("gio"));
        }

//        xnTxtTongTien.setText(global.getmTongTien());

        xnBtnChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        xnBtnDatVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                global.setDiemLen(xnTxtDiemDon.getText().toString());
                global.setDiemXuong(xnTxtDiemXuong.getText().toString());
                global.setViTriGhe(xnTxtGhe.getText().toString());
                global.setNgayKhoiHanh(xnTxtNgayDi.getText().toString());
                global.settGian(xnTxtGioDi.getText().toString());
                Thread th = new Thread(taskLog);
                th.start();
                Intent intent = new Intent(getApplicationContext(), Vecuatoi.class);
                startActivity(intent);

            }
        });
    }

    private void anhxa() {
        xnBtnChinhSua = findViewById(R.id.btnChinhsua);
        xnBtnDatVe = findViewById(R.id.btnDatve);
        xnTxtSdt = findViewById(R.id.txtSdt);
        xnTxtDiemDon = findViewById(R.id.txtDiemDon);
        xnTxtDiemXuong = findViewById(R.id.txtDiemXuong);
        xnTxtGhe = findViewById(R.id.Ghe);
        xnTxtNgayDi = findViewById(R.id.txtNgaydi);
        xnTxtGioDi = findViewById(R.id.txtGiodi);
        xnTxtTongTien = findViewById(R.id.txtTongTien);
    }
}
