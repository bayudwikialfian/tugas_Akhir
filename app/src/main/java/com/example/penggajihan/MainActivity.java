package com.example.penggajihan;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button _btnLogin;
    private EditText _ETUsername, _ETpassword;
    private ProgressBar progressBar;

    Spinner spinner;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _ETUsername = findViewById(R.id.ETusername);
        _ETpassword = findViewById(R.id.ETpassword);
        spinner = findViewById(R.id.spinner);
        _btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String item = spinner.getSelectedItem().toString();

                if( _ETUsername.getText().toString().equals("admin") && _ETpassword.getText().toString().equals("admin") && item.equals("admin")){

                Intent intent = new Intent(MainActivity.this, Menuadmin.class);
                startActivity(intent);
                }else  if (_ETUsername.getText().toString().equals("admin") && _ETpassword.getText().toString().equals("admin") && item.equals("user")){
                    Intent intent = new Intent(MainActivity.this, Menuuser.class);
                    startActivity(intent);
            }else {
                    Toast.makeText(getApplication(),"Error",Toast.LENGTH_SHORT).show();
                }
        }
    });
    }

}