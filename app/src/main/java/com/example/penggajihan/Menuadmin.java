package com.example.penggajihan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menuadmin extends AppCompatActivity {

    private Button btnDataKaryawan,btnRincianGajih,btnMenagemenkaryawan,btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuadmin);
        Button btnKeluar = findViewById(R.id.btnKeluar);
        Button btnDataKaryawan = findViewById(R.id.btnDataKaryawan);
        Button btnRincianGajih = findViewById(R.id.btnRincianGajih);
        Button btnMenagemenkaryawan = findViewById(R.id.btnMenagemenkaryawan);


        btnDataKaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), datakaryawan.class);
                startActivity(intent1);
            }
        });

        btnMenagemenkaryawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), menegamen.class);
                startActivity(intent2);
            }
        });
        btnRincianGajih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), gaji.class);
                startActivity(intent3);
            }
        });
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent4);

            }
        });
    }
}