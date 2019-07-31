package com.example.a3t_travel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a3t_travel.Entity.KhachHangManager;
import com.example.a3t_travel.Entity.ResultEntity;
import com.example.a3t_travel.Menu.activity_thongtinkhachhang;

import org.json.JSONException;

public class Login extends AppCompatActivity {

    Button lBtnDangNhap, lBtnDangKy;
    EditText lEtSdt, lEdtMatkhau;
    SharedPreferences lSharedPreferences;
    ProgressDialog lPrD;
    Server server = new Server();
    ApplicationContextGlobal global = new ApplicationContextGlobal();
    Runnable taskLog = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lPrD.show(); // Bật dialog progress
                }
            });

            final String sdt = lEtSdt.getText().toString();
            final String matkhau = lEdtMatkhau.getText().toString();

            String data[][] = {
                    {"sodienthoai", sdt},{"matkhau", matkhau}
            };
            final String result = server.sendRequest(1,
                    Constant.HOSTING_API + Constant.PAGE_INDEX, data);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    lPrD.dismiss(); // Tắt dialog progress
                    try {
                        KhachHangManager manager = new KhachHangManager(result);
                        // Nếu đăng nhập sai
                        if (manager.listKH.size() == 0) {
                            Toast.makeText(Login.this, "Không tồn tại tài khoản hoặc sai !", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent1 = new Intent(Login.this, Main2Activity.class);

                            //luu ma khach hang cung phien lam viec.
                            global.setMaKhachHang(manager.listKH.get(0).getMakhachhang());

                            intent1.putExtra("tenkhachhang", manager.listKH.get(0).getTenkhachhang());
                            startActivity(intent1);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(Login.this, "Dữ liệu lỗi", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lPrD = new ProgressDialog(Login.this);
        lPrD.setMessage("Vui lòng đợi trong chốc lát");
        lPrD.setCancelable(false);

        anhxa();
        lSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        //lấy giá trị key: dienthoai đã lưu
        lEtSdt.setText(lSharedPreferences.getString("dienthoai", ""));


        lBtnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lEtSdt.getText().length() <= 9 || lEtSdt.getText().length() > 11) {
                    Toast.makeText(Login.this, "Vui lòng nhập đúng số điện thoại", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences.Editor editor = lSharedPreferences.edit();
                    editor.putString("dienthoai", lEtSdt.getText().toString().trim());
                    editor.commit();
                    Thread thread = new Thread(taskLog);
                    thread.start();
                }
                ApplicationContextGlobal.setSdt(lEtSdt.getText().toString());
//                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            }
        });

        lBtnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, DangKy.class);
                startActivity(intent);

            }
        });

    }

    private void Intent() {
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
    }

    private void anhxa() {
        lBtnDangNhap = findViewById(R.id.btndangnhap);
        lBtnDangKy = findViewById(R.id.btndangky);
        lEtSdt = findViewById(R.id.etsdt);
        lEdtMatkhau = findViewById(R.id.etMatKhau);
    }
}
