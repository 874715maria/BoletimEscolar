package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private ImageButton imageButton_voltarMainActivity;
    private Button button_salvarCadastro;
//    private TextInputEditText textInputEditText_nome, textInputEditText_email, textInputEditText_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        imageButton_voltarMainActivity = (ImageButton) findViewById(R.id.imageButton_voltarMainActivity);
        button_salvarCadastro = (Button) findViewById(R.id.button_salvarCadastro);

        //chamada do método para voltar a tela de LOGOFF do app
        imageButton_voltarMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarMainActivity();
            }
        });

        //chamada do método de login no botão ENTRAR da tela de login
        button_salvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCadastro();
            }
        });
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Metodo para enviar os dados do cadastro para o BD e ir para a tela início do app (não logado/tela de cadastro e login)
    public void salvarCadastro() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}