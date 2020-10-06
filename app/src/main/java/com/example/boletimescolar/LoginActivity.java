package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    ImageButton imageButton_voltarMainActivity;
    Button button_entrarLogin;
    TextInputEditText textInputEditText_email, textInputEditText_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imageButton_voltarMainActivity = (ImageButton) findViewById(R.id.button_voltarMainActivityLogin);
        button_entrarLogin = (Button) findViewById(R.id.button_entrarLogin);

        //chamada do método para voltar a tela de LOGOFF do app
        imageButton_voltarMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarMainActivity();

            }
        });

        //chamada do método de login no botão ENTRAR da tela de login
        button_entrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efetuarLogin();
            }
        });
    }

    //Metodo para fazer o login e ir para a tela início do app (quando logado)
    private void efetuarLogin() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    private void voltarMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}