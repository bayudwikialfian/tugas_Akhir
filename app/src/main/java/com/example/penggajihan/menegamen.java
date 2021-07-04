package com.example.penggajihan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class menegamen extends AppCompatActivity {


    EditText ETnama, ETnik, ETemail, ETpassword;
    Button btndaftar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menegamen);


        ETnama = findViewById(R.id.nama);
        ETnik = findViewById(R.id.nik);
        ETemail = findViewById(R.id.email);
        ETpassword = findViewById(R.id.Password);
        btndaftar = findViewById(R.id.daftar);


        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                reference = firebaseDatabase.getReference("daftar karyawan");

                String nik = ETnik.getText().toString();
                String nama = ETnama.getText().toString();
                String username = ETemail.getText().toString();
                String password = ETpassword.getText().toString();
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
                if (username.isEmpty()) {
                    TextView inputName = null;
                    inputName.setError(getString(R.string.eror_username));
                    inputName.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    TextView inputName = null;
                    inputName.setError(getString(R.string.eror_password));
                    inputName.requestFocus();
                    return;
                }

                Connect connect = new Connect(username, password);
                reference.child(connect.getNik()).setValue(connect).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(menegamen.this,"memasukan data karyawan sukses",
                                    Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(menegamen.this,"gagal.......",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
