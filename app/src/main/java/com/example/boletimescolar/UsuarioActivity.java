package com.example.boletimescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UsuarioActivity extends AppCompatActivity {

    private Button buttonSalvar, buttonCancelar;

    private EditText editTextNome;
    private EditText editTextIdade;
    private EditText editTextEmail;
    private EditText editTextNomeEscola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        buttonSalvar = (Button) findViewById(R.id.button_Salvar);
        buttonCancelar = (Button) findViewById(R.id.button_Cancelar);

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextNomeEscola = (EditText) findViewById(R.id.editTextNomeEscola);
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity(View view) {
       finish();
    }

}