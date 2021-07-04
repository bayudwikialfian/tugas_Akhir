package com.example.penggajihan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;


public class gaji extends AppCompatActivity {


    EditText ETnama, ETnik, ETgapok, ETharikerja, ETtunjanganjabatan;
    TextView TVtunjanganmakan, TVtunjangantransport, TVgajikotor, TVgajibersih, TVtunjangankesehatan;
    Button btnsimpan, btnhitung;

    Double Vharikerja, Vtunjanganmakan, Vtunjangantrasportasi, Vgajikotor, Vpajak, Vgajibersih, Vgajipokok, Vtunjanganjabatan, Vtunjangankesehatan;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji);

        ETnama = findViewById(R.id.ETnama);
        ETnik = findViewById(R.id.ETnik);
        ETgapok = findViewById(R.id.ETgapok);
        ETharikerja = findViewById(R.id.EThari);
        ETtunjanganjabatan = findViewById(R.id.ETtunjanganjabatan);
        TVtunjanganmakan = findViewById(R.id.TVtunjanganmakan);
        TVtunjangantransport = findViewById(R.id.TVtunjngantransport);
        TVgajikotor = findViewById(R.id.TVgajikotor);
        TVgajibersih = findViewById(R.id.TVgajibersih);
        TVtunjangankesehatan = findViewById(R.id.TVtunjngankesehatan);
        btnsimpan = findViewById(R.id.btnsimpan);
        btnhitung = findViewById(R.id.btnhitung);
    }

    public void Hitung(View view) {
        if (ETnama.length() == 0) {
            Toast.makeText(getApplication(), "nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (ETnik.length() == 0) {
            Toast.makeText(getApplication(), "nomor tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (ETharikerja.length() == 0) {
            Toast.makeText(getApplication(), "gaji pokok tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (ETgapok.length() == 0) {
            Toast.makeText(getApplication(), "tunjangan jabatan tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (ETtunjanganjabatan.length() == 0) {
            Toast.makeText(getApplication(), "jumlah hari tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else {
            hasil();



            }
        }


        public void simpan (View view){
            firebaseDatabase = FirebaseDatabase.getInstance();
            reference = firebaseDatabase.getReference(" rincian gaji");

            String nik = ETnik.getText().toString();
            String nama = ETnama.getText().toString();
            String gajipokok = ETgapok.getText().toString();
            String gajibersih = TVgajibersih.getText().toString();
            String hari = ETharikerja.getText().toString();
            String gajikotor = TVgajikotor.getText().toString();
            String tunjangantransport = TVtunjangantransport.getText().toString();
            String tunjanganmakan = TVtunjanganmakan.getText().toString();
            String tunjanganjabatan = ETtunjanganjabatan.getText().toString();
            String tunjangankesehatan = TVtunjangankesehatan.getText().toString();


            if (nik.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }
            if (nama.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }

            if (gajipokok.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }
            if (gajibersih.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }

            if (hari.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }

            if (gajikotor.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }

            if (tunjangantransport.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }

            if (tunjanganmakan.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }
            if (tunjanganjabatan.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }

            if (tunjangankesehatan.isEmpty()) {
                TextView inputName = null;

                inputName.requestFocus();
                return;
            }


            Connect connect = new Connect(nama, nik, hari, gajipokok, gajibersih,
                    gajikotor, tunjangantransport, tunjanganmakan, tunjanganjabatan, tunjangankesehatan);
            reference.child(nik).setValue(connect);
            Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
            finish();


        }

    private void hasil() {
        DecimalFormat formatter = new DecimalFormat(" ###,###,###");
        Vharikerja = Double.parseDouble(ETharikerja.getText().toString());
        Vgajipokok = Double.parseDouble(ETgapok.getText().toString());
        Vtunjanganjabatan = Double.parseDouble((ETtunjanganjabatan.getText().toString()));

        Vtunjanganmakan = Vharikerja * 25000;
        Vtunjangantrasportasi = Vharikerja * 20000;
        Vtunjangankesehatan = Vharikerja * 35000;
        Vgajikotor = Vgajipokok + Vtunjanganjabatan + Vtunjanganmakan + Vtunjangantrasportasi + Vtunjangankesehatan;
        Vpajak = Vgajikotor * 0.1;
        Vgajibersih = Vgajikotor - Vpajak;

        TVtunjanganmakan.setText("uang makan =Rp." + formatter.format(Vtunjanganmakan));
        TVtunjangantransport.setText("tunjangan transport =Rp." + formatter.format(Vtunjangantrasportasi));
        TVtunjangankesehatan.setText("tunjangan kesehatan =Rp." + formatter.format(Vtunjangankesehatan));
        TVgajikotor.setText("gaji kotor =Rp." + formatter.format(Vgajikotor));
        TVgajibersih.setText("gaji bersih =Rp." + formatter.format(Vgajibersih));
    }

}