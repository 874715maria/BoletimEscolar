package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MateriaActivity extends AppCompatActivity {

    private Button buttonSalvar, buttonCancelar;

    private EditText editTextTextPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_materia);

        buttonSalvar =  (Button) findViewById(R.id.buttonSalvar);
        buttonCancelar = (Button) findViewById(R.id.buttonCancelar);

        editTextTextPersonName = (EditText) findViewById(R.id.editText_nomeMateria);

    }
    public void salvarMateria(View view) {
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    //Metodo para voltar para a tela inicial dos cadastros
    public void voltarMainActivity(View view) {
       finish();
    }

   /* public void salvar (View view){
        this.materia.setNome(this.editTextTextPersonName.getText().toString());
        this.materia.salvar();

        Toast.makeText(this,this.materia.getMensagem(),Toast.LENGTH_LONG).show();
        if (materia.is_status())
            finish();
    }

    public void cancelar (View view){
        finish();
    }*/
}