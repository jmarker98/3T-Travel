package com.example.a3t_travel;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3t_travel.Entity.KhachHangManager;

import org.json.JSONException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Datve extends AppCompatActivity {

    EditText sdt;
    TextView edtNgayKhoiHanh, txtGhe;
    Spinner spnDiemLenXe, spnDiemXuongXe, spnThanhToan, spthoigian;
    ImageView imgLich, imgchuyen, imgback;
    Button btntieptuc, btnchoncho;
    ApplicationContextGlobal global = new ApplicationContextGlobal();
    int click = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datve);
        anhxa();
        Spinner();

        txtGhe.setText(global.getViTriGhe());

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            txtGhe.setText(bundle.getString("vitrighe"));
        }

        edtNgayKhoiHanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });

        imgLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                global.setMaThanhToan(1);
                if (edtNgayKhoiHanh.getText().length() < 8 || sdt.getText().length() < 9 || sdt.getText().length() > 11) {
                    Toast.makeText(Datve.this, "Vui lòng cung cấp đầy đủ thông tin!", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(getApplicationContext(), XacNhanThongTin.class);
                    intent.putExtra("ghe", txtGhe.getText().toString());
                    intent.putExtra("len", spnDiemLenXe.getSelectedItem().toString());
                    intent.putExtra("xuong", spnDiemXuongXe.getSelectedItem().toString());
                    intent.putExtra("ngay", edtNgayKhoiHanh.getText().toString());
                    intent.putExtra("gio", spthoigian.getSelectedItem().toString());
                    intent.putExtra("sdt", sdt.getText().toString());
                    startActivity(intent);
                }
            }
        });
        btnchoncho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Datve.this, choncho.class);
                startActivity(intent);
            }
        });

    }

    private void chonngay() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                edtNgayKhoiHanh.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }

    private void anhxa() {
        edtNgayKhoiHanh = findViewById(R.id.edtNgayKhoiHanh);
        spnDiemLenXe = findViewById(R.id.spnDiemLen);
        spnDiemXuongXe = findViewById(R.id.spnDiemXuong);
        spnThanhToan = findViewById(R.id.spnThanhToan);
        imgLich = findViewById(R.id.imgLich);
        imgchuyen = findViewById(R.id.imgChieu);
        sdt = findViewById(R.id.sdt);
        imgback = findViewById(R.id.imgback);
        btntieptuc = findViewById(R.id.btntieptuc);
        spthoigian = findViewById(R.id.sptime);
        btnchoncho = findViewById(R.id.btnChonCho);
        txtGhe = findViewById(R.id.txtLayGhe);

    }

    private void Spinner() {
        ArrayList<String> diemlen = new ArrayList<>();
        diemlen.add("Sân bóng Nam Sơn");
        diemlen.add("Làng Nhân Hậu");
        diemlen.add("Cây Bàng Nam Sơn");
        diemlen.add("Đặng Sơn");
        diemlen.add("Cầu Đô Lương");

        ArrayList<String> diemxuong = new ArrayList<>();
        diemxuong.add("Văn Phòng Mỗ Lao");
        diemxuong.add("Văn Phòng Giải Phóng");
        diemxuong.add("Bến xe Nước Ngầm");
        diemxuong.add("Thành Phố Ninh Bình");
        diemxuong.add("KCN Bắc Ninh");

        ArrayList<String> thanhtoan = new ArrayList<>();
        thanhtoan.add("Thanh toán trực tiếp");
        thanhtoan.add("Chuyển khoản");

        
        ArrayList<String> thoigian1 = new ArrayList<>();
        thoigian1.add("09:00");
        thoigian1.add("20:00");

        ArrayList<String> thoigian2 = new ArrayList<>();
        thoigian2.add("11:30");
        thoigian2.add("21:00");

        final ArrayAdapter adapterdiemxuong = new ArrayAdapter(Datve.this, android.R.layout.simple_list_item_1, diemxuong);
        final ArrayAdapter adapterdiemlen = new ArrayAdapter(Datve.this, android.R.layout.simple_list_item_1, diemlen);
        final ArrayAdapter adaptertt = new ArrayAdapter(Datve.this, android.R.layout.simple_list_item_1, thanhtoan);
        final ArrayAdapter adaptertime1 = new ArrayAdapter(Datve.this, android.R.layout.simple_list_item_1, thoigian1);
        final ArrayAdapter adaptertime2 = new ArrayAdapter(Datve.this, android.R.layout.simple_list_item_1, thoigian2);

        spnDiemLenXe.setAdapter(adapterdiemlen);
        spnDiemXuongXe.setAdapter(adapterdiemxuong);
        spnThanhToan.setAdapter(adaptertt);
        spthoigian.setAdapter(adaptertime1);

        imgchuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click % 2 != 0) {
                    spnDiemLenXe.setAdapter(adapterdiemxuong);
                    spnDiemXuongXe.setAdapter(adapterdiemlen);
                    spthoigian.setAdapter(adaptertime2);
                    click++;
                } else {
                    spnDiemLenXe.setAdapter(adapterdiemlen);
                    spnDiemXuongXe.setAdapter(adapterdiemxuong);
                    spthoigian.setAdapter(adaptertime1);
                    click++;
                }
            }
        });

    }

}

