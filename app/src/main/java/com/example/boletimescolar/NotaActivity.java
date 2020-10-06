package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotaActivity extends AppCompatActivity {

    private Button buttonSalvar, buttonCancelar;

    private EditText editTextPeriodo;
    private EditText editTextUnidade;
    private EditText editTextNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadasto_nota);

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonCancelar = (Button) findViewById(R.id.buttonCancelar);

        editTextPeriodo = (EditText) findViewById(R.id.editTextPeriodo);
        editTextUnidade = (EditText) findViewById(R.id.editTextUnidade);
        editTextNota = (EditText) findViewById(R.id.editTextNota);
    }
    public void salvarNota(View view) {
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity(View view) {
        finish();
    }
    /*public void salvar (View view){
        this.nota.setPeriodo(this.editTextPeriodo.getText().toString());
        this.nota.setUnidade(this.editTextUnidade.getText().toString());
        this.nota.setNota(this.editTextNota.getText().toString());
        this.nota.salvar();

        Toast.makeText(this,this.nota.getMensagem(),Toast.LENGTH_LONG).show();
        if (nota.is_status())
            finish();
    }

    public void cancelar (View view){
        finish();
    }*/
}
