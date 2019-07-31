package com.example.a3t_travel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3t_travel.Entity.ResultEntity;

import org.json.JSONException;

public class choncho extends AppCompatActivity {
    int sl;
    int thanhtoan;
    ApplicationContextGlobal global = new ApplicationContextGlobal();
    ImageView cImgBack;
    Button btnTieptuc;
    TextView tvSoluong, tvGhe, tvTien;
    CheckBox cbA1, cbA2, cbA3, cbA4, cbA5, cbA6, cbA7, cbA8, cbA9, cbA10,
            cbB1, cbB2, cbB3, cbB4, cbB5, cbB6, cbB7, cbB8, cbB9, cbB10,
            cbC1, cbC2, cbC3, cbC4, cbC5, cbC6, cbC7, cbC8, cbC9, cbC10;


    ProgressDialog mPrD;
    Runnable taskAdd = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mPrD.show(); // Bật dialog progress
                }
            });

            int makh = global.getMaKhachHang();
            int matuyen = global.getMaTuyen();
            int slv = global.getSoLuongVe();
            int thanhtien = thanhtoan;

            String data[][] = {
                    {"makhachhang", String.valueOf(makh)},
                    {"matuyen", String.valueOf(matuyen)},
                    {"soluongve", String.valueOf(slv)},
                    {"thanhtien", String.valueOf(thanhtien)}
            };

            Server server = new Server();
            final String result = server.sendRequest(1,
                    Constant.HOSTING_API + Constant.PAGE_ADDHD, data);
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
                    finish();
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choncho);

        anhxa();
        mPrD = new ProgressDialog(choncho.this);
        mPrD.setMessage("Vui lòng đợi trong chốc lát");
        mPrD.setCancelable(false);

        cImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnTieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread th = new Thread(taskAdd);
                th.start();
                Intent intent = new Intent(getApplicationContext(), Datve.class);
                global.setSoLuongVe(Integer.parseInt(tvSoluong.getText().toString()));
                //global.setmTongTien(Long.parseLong(tvTien.getText().toString()));
                global.setmTongTien(thanhtoan);
                intent.putExtra("vitrighe", tvGhe.getText().toString());
                startActivity(intent);
//                finish();

            }

        });
        cbA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA1);
            }
        });
        cbA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA2);
            }
        });
        cbA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA3);
            }
        });
        cbA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA4);
            }
        });
        cbA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA5);
            }
        });
        cbA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA6);
            }
        });
        cbA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA7);
            }
        });
        cbA8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA8);
            }
        });
        cbA9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbA9);
            }
        });

        cbB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB1);
            }
        });
        cbB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB2);
            }
        });
        cbB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB3);
            }
        });
        cbB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB4);
            }
        });
        cbB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB5);
            }
        });
        cbB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB6);
            }
        });
        cbB7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB7);
            }
        });
        cbB8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB8);
            }
        });
        cbB9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB9);
            }
        });
        cbB10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbB10);
            }
        });

        cbC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC1);
            }
        });
        cbC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC2);
            }
        });
        cbC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC3);
            }
        });
        cbC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC4);
            }
        });
        cbC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC5);
            }
        });
        cbC6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC6);
            }
        });
        cbC7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC7);
            }
        });
        cbC8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC8);
            }
        });
        cbC9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC9);
            }
        });
        cbC10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(cbC10);
            }
        });
    }

    public void anhxa() {
        tvSoluong = findViewById(R.id.txtSL);
        tvGhe = findViewById(R.id.txtGhe);
        tvTien = findViewById(R.id.txtTongtien);

        cImgBack = findViewById(R.id.imgback);
        btnTieptuc = findViewById(R.id.btnOk);

        cbA1 = findViewById(R.id.checkA1);
        cbA2 = findViewById(R.id.checkA2);
        cbA3 = findViewById(R.id.checkA3);
        cbA4 = findViewById(R.id.checkA4);
        cbA5 = findViewById(R.id.checkA5);
        cbA6 = findViewById(R.id.checkA6);
        cbA7 = findViewById(R.id.checkA7);
        cbA8 = findViewById(R.id.checkA8);
        cbA9 = findViewById(R.id.checkA9);
        cbA10 = findViewById(R.id.checkA10);

        cbB1 = findViewById(R.id.checkB1);
        cbB2 = findViewById(R.id.checkB2);
        cbB3 = findViewById(R.id.checkB3);
        cbB4 = findViewById(R.id.checkB4);
        cbB5 = findViewById(R.id.checkB5);
        cbB6 = findViewById(R.id.checkB6);
        cbB7 = findViewById(R.id.checkB7);
        cbB8 = findViewById(R.id.checkB8);
        cbB9 = findViewById(R.id.checkB9);
        cbB10 = findViewById(R.id.checkB10);

        cbC1 = findViewById(R.id.checkC1);
        cbC2 = findViewById(R.id.checkC2);
        cbC3 = findViewById(R.id.checkC3);
        cbC4 = findViewById(R.id.checkC4);
        cbC5 = findViewById(R.id.checkC5);
        cbC6 = findViewById(R.id.checkC6);
        cbC7 = findViewById(R.id.checkC7);
        cbC8 = findViewById(R.id.checkC8);
        cbC9 = findViewById(R.id.checkC9);
        cbC10 = findViewById(R.id.checkC10);

    }


    public void check(View view) {
        int click = 0;
        String msg = "";
        if (cbA1.isChecked()) {
            msg += cbA1.getText().toString() + "\t";
            click++;
        }
        if (cbA2.isChecked()) {
            msg += cbA2.getText().toString() + "\t";
            click++;

        }
        if (cbA3.isChecked()) {
            msg += cbA3.getText().toString() + "\t";
            click++;
        }
        if (cbA4.isChecked()) {
            msg += cbA4.getText().toString() + "\t";
            click++;
        }
        if (cbA5.isChecked()) {
            msg += cbA5.getText().toString() + "\t";
            click++;
        }
        if (cbA6.isChecked()) {
            msg += cbA6.getText().toString() + "\t";
            click++;
        }
        if (cbA7.isChecked()) {
            msg += cbA7.getText().toString() + "\t";
            click++;
        }
        if (cbA8.isChecked()) {
            msg += cbA8.getText().toString() + "\t";
            click++;
        }
        if (cbA9.isChecked()) {
            msg += cbA9.getText().toString() + "\t";
            click++;
        }
        if (cbA10.isChecked()) {
            msg += cbA10.getText().toString() + "\t";
            click++;
        }


        if (cbB1.isChecked()) {
            msg += cbB1.getText().toString() + "\t";
            click++;
        }
        if (cbB2.isChecked()) {
            msg += cbB2.getText().toString() + "\t";
            click++;
        }
        if (cbB3.isChecked()) {
            msg += cbB3.getText().toString() + "\t";
            click++;
        }
        if (cbB4.isChecked()) {
            msg += cbB4.getText().toString() + "\t";
            click++;
        }
        if (cbB5.isChecked()) {
            msg += cbB5.getText().toString() + "\t";
            click++;
        }
        if (cbB6.isChecked()) {
            msg += cbB6.getText().toString() + "\t";
            click++;
        }
        if (cbB7.isChecked()) {
            msg += cbB7.getText().toString() + "\t";
            click++;
        }
        if (cbB8.isChecked()) {
            msg += cbB8.getText().toString() + "\t";
            click++;
        }
        if (cbB9.isChecked()) {
            msg += cbB9.getText().toString() + "\t";
            click++;
        }
        if (cbB10.isChecked()) {
            msg += cbB10.getText().toString() + "\t";
            click++;
        }

        if (cbC1.isChecked()) {
            msg += cbC1.getText().toString() + "\t";
            click++;
        }
        if (cbC2.isChecked()) {
            msg += cbC2.getText().toString() + "\t";
            click++;
        }
        if (cbC3.isChecked()) {
            msg += cbC3.getText().toString() + "\t";
            click++;
        }
        if (cbC4.isChecked()) {
            msg += cbC4.getText().toString() + "\t";
            click++;
        }
        if (cbC5.isChecked()) {
            msg += cbC5.getText().toString() + "\t";
            click++;
        }
        if (cbC6.isChecked()) {
            msg += cbC6.getText().toString() + "\t";
            click++;
        }
        if (cbC7.isChecked()) {
            msg += cbC7.getText().toString() + "\t";
            click++;
        }
        if (cbC8.isChecked()) {
            msg += cbC8.getText().toString() + "\t";
            click++;
        }
        if (cbC9.isChecked()) {
            msg += cbC9.getText().toString() + "\t";
            click++;
        }
        if (cbC10.isChecked()) {
            msg += cbC10.getText().toString() + "\t";
            click++;
        }

        tvGhe.setText(msg + "");
        tvSoluong.setText(click + "");

        sl = Integer.parseInt(tvSoluong.getText().toString());

        // kiem tra tinh tien theo ma tuyen bang application
        if (global.getMaTuyen() == 1) {
            thanhtoan = sl * 180000;
        } else if (global.getMaTuyen() == 2) {
            thanhtoan = sl * 210000;
        }
        tvTien.setText(thanhtoan+"");

    }
}