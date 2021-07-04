package com.example.penggajihan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;


public class datakaryawan extends AppCompatActivity {

    EditText ETnama, ETnik, ETalamat, ETjabatan;
    Button tambah, btnhapusdata, ubahdata;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    private FirebaseDatabase hapus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datakaryawan);
        ETnama = findViewById(R.id.nama);
        ETnik = findViewById(R.id.nik);
        ETalamat = findViewById(R.id.alamat);
        ETjabatan = findViewById(R.id.jabatan);


        tambah = findViewById(R.id.tambah);
        btnhapusdata = findViewById(R.id.hapusdata);

        btnhapusdata.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {

                                                tambah.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        firebaseDatabase = FirebaseDatabase.getInstance();
                                                        reference = firebaseDatabase.getReference("data karyawan");

                                                        String nik = ETnik.getText().toString();
                                                        String nama = ETnama.getText().toString();
                                                        String alamat = ETalamat.getText().toString();
                                                        String jabatan = ETjabatan.getText().toString();


                                                        if (nik.isEmpty()) {
                                                            TextView inputName = null;
                                                            inputName.setError(getString(R.string.eror_nik));
                                                            inputName.requestFocus();
                                                            return;
                                                        }
                                                        if (nama.isEmpty()) {
                                                            TextView inputName = null;
                                                            inputName.setError(getString(R.string.eror_nama));
                                                            inputName.requestFocus();
                                                            return;
                                                        }
                                                        if (alamat.isEmpty()) {
                                                            TextView inputName = null;
                                                            inputName.setError(getString(R.string.eror_alamat));
                                                            inputName.requestFocus();
                                                            return;
                                                        }
                                                        if (jabatan.isEmpty()) {
                                                            TextView inputName = null;
                                                            inputName.setError(getString(R.string.eror_jabatan));
                                                            inputName.requestFocus();
                                                            return;
                                                        }
                                                        Connect connect = new Connect(nik, nama, alamat, jabatan);
                                                        reference.child(nik).setValue(connect);
                                                        Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();
                                                        finish();
                                                    }

                                                });
                                            }
        }
        );




    }
}