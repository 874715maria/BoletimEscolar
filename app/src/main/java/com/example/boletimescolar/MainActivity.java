package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boletimescolar.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void chamarTelaLogin() {
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
//    }

    public void chamarTelaCadastro() {
        Intent intent = new Intent(getApplicationContext(), CadastrarActivity.class);
        startActivity(intent);
    }
}