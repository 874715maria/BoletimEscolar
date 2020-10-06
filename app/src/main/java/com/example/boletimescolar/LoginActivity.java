package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private ImageButton imageButton_voltarMainActivity;
    private Button button_entrarLogin, button_entrar, buttonLogin;
    private EditText inputText_email, inputText_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        button_entrar = (Button) findViewById(R.id.button_entrar);
        imageButton_voltarMainActivity = (ImageButton) findViewById(R.id.button_voltarMainActivityLogin);

        inputText_email = (EditText) findViewById(R.id.inputText_email);
        inputText_password = (EditText) findViewById(R.id.inputText_password);

    }

    //Metodo para fazer o login e ir para a tela início do app (quando logado)
    public void efetuarLogin(View view) {
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity(View view) {
        finish();
    }


}