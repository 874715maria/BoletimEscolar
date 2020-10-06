package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private ImageButton imageButton_voltarMainActivity;
    private Button button_salvarCadastro;
    private EditText inputText_Nome, inputText_Email, inputText_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        imageButton_voltarMainActivity = (ImageButton) findViewById(R.id.imageButton_voltarMainActivity);
        button_salvarCadastro = (Button) findViewById(R.id.button_salvarCadastro);

        inputText_Nome = (EditText) findViewById(R.id.inputText_Nome);
        inputText_Email = (EditText) findViewById(R.id.inputText_email);
        inputText_Password = (EditText) findViewById(R.id.inputText_password);

    }
    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity(View view) {
        finish();
    }

    //Metodo para enviar os dados do cadastro para o BD e ir para a tela início do app (não logado/tela de cadastro e login)
    public void salvarCadastro(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}