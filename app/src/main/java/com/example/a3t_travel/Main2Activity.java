package com.example.a3t_travel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.a3t_travel.Menu.GioiThieu;
import com.example.a3t_travel.Menu.HuongDan;
import com.example.a3t_travel.Menu.activity_thongtinkhachhang;

public class Main2Activity extends AppCompatActivity {
    Button m2BtnVeCuaToi;
    TextView m2TxtXinChao;
    ImageView m2Img1, m2ImgMenu, m2Img2;
    ApplicationContextGlobal global = new ApplicationContextGlobal();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhxa();
        Intent intent = getIntent();
//        m2TxtXinChao.setText(intent.getStringExtra("sodienthoai"));
        m2TxtXinChao.setText(intent.getStringExtra("tenkhachhang"));
        m2Img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                global.setMaTuyen(1);
                Intent intent = new Intent(getApplicationContext(), Datve.class);
                startActivity(intent);
            }
        });
        m2ImgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
        m2Img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                global.setMaTuyen(2);
                Intent intent = new Intent(getApplicationContext(), Datve.class);
                startActivity(intent);
            }
        });

//        //cai dat cho hien thi txtxinchao
//        if (ApplicationContextGlobal.getHoTen() == null) {
//            m2TxtXinChao.setText(ApplicationContextGlobal.getSdt());
//        } else {
//            m2TxtXinChao.setText(ApplicationContextGlobal.getHoTen());
//        }
        m2BtnVeCuaToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Vecuatoi.class);
                startActivity(intent);
            }
        });
    }

    private void showMenu() {
        PopupMenu popupMenu = new PopupMenu(this, m2ImgMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.mdangxuat:
                        Intent intent = new Intent(Main2Activity.this, Login.class);
                        startActivity(intent);
                        break;
                    case R.id.mthongbao:
                        break;
                    case R.id.mdieukhoan:
                        Intent intent4 = new Intent(Main2Activity.this, GioiThieu.class);
                        startActivity(intent4);
                        break;
                    case R.id.mgioithieu:
                        Intent intent1 = new Intent(Main2Activity.this, GioiThieu.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.mlichsu:
                        break;
                    case R.id.mhuongdan:
                        Intent intent3 = new Intent(Main2Activity.this, HuongDan.class);
                        startActivity(intent3);
                        break;
                    case R.id.mthongtincanhan:
                        Intent intent2 = new Intent(Main2Activity.this, activity_thongtinkhachhang.class);
                        startActivity(intent2);
                        break;
                    case R.id.mtintuc:
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void anhxa() {
        m2Img1 = findViewById(R.id.imgdoluong);
        m2TxtXinChao = findViewById(R.id.txtxinchao);
        m2ImgMenu = findViewById(R.id.imgMenu);
        m2Img2 = findViewById(R.id.imgConCuong);
        m2BtnVeCuaToi = findViewById(R.id.btnvecuatoi);
    }

}
