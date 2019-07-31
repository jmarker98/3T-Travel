package com.example.a3t_travel;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.a3t_travel.Entity.ResultEntity;

import org.json.JSONException;

public class DangKy extends AppCompatActivity {
    EditText edtSDT, edtTen, edtMK, edtConfirmMK;
    ProgressDialog mPrD;
    Runnable taskReg = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mPrD.show();
                }
            });

            String tenkh = getDataForm(R.id.edtHoTen);
            String sdt = getDataForm(R.id.edtTaiKhoan);
            String matkhau = getDataForm(R.id.edtMatKhau);

            String data[][] = {
                    {"tenkhachhang", tenkh},
                    {"sodienthoai", sdt},
                    {"matkhau", matkhau},
            };

            Server server = new Server();
            final String result = server.sendRequest(1,
                    Constant.HOSTING_API + Constant.PAGE_INSERT, data);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mPrD.dismiss(); // Tắt dialog progress
                    ResultEntity resultEntity = null;
                    try {
                        resultEntity = new ResultEntity(result);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (resultEntity == null) {
                        Log.e("3T", "NULL");
                    }
                    Toast.makeText(DangKy.this, "Đăng ký " +
                            resultEntity.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    };

    private String getDataForm(int resource) {
        EditText text = findViewById(resource);
        return text.getText().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        anhxa();
        Button btnDangKy = findViewById(R.id.btnDangky);
        ImageView dkImgBack = findViewById(R.id.imgback);


        // Khởi tạo dialog progress
        mPrD = new ProgressDialog(DangKy.this);
        mPrD.setMessage("Vui lòng đợi trong chốc lát");
        mPrD.setCancelable(false);

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSDT.getText().length() < 1
                        || edtTen.getText().length() < 1
                        || edtMK.getText().length() < 1
                        || edtConfirmMK.getText().length() < 1) {
                    Toast.makeText(DangKy.this, "Bạn phải nhập đủ thông tin !!", Toast.LENGTH_SHORT).show();
                }
                else if(!edtMK.equals(edtConfirmMK)){
                    Toast.makeText(DangKy.this, "Mật khẩu chưa đúng !!", Toast.LENGTH_SHORT).show();
                }

                else {
                    Thread th = new Thread(taskReg);
                    th.start();
                }
            }
        });
        dkImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public void anhxa() {
        edtSDT = findViewById(R.id.edtTaiKhoan);
        edtTen = findViewById(R.id.edtHoTen);
        edtMK = findViewById(R.id.edtMatKhau);
        edtConfirmMK = findViewById(R.id.edtreMatKhau);
    }

}

