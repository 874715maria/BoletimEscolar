package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class NotaActivity extends AppCompatActivity {

    private Button buttonSalvar, buttonCancelar;
    private Spinner spinnerMateria, spinnerPeriodo, spinnerUnidade;
    private EditText editTextNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadasto_nota);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        buttonCancelar = findViewById(R.id.buttonCancelar);

        spinnerMateria = findViewById(R.id.spinner_materia);
        //No Array abaixo deve receber a lista de matérias salvas no BD no lugar de "R.array.periodo"
//        ArrayAdapter<String> arrayAdapterMateria = new ArrayAdapter<String>(NotaActivity.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.periodo));
//        arrayAdapterMateria.setDropDownViewResource(android.R.layout.simple_list_item_1);
//        spinnerMateria.setAdapter(arrayAdapterMateria);

        spinnerPeriodo = findViewById(R.id.spinner_periodo);
        ArrayAdapter<String> arrayAdapterPeriodo = new ArrayAdapter<String>(NotaActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.periodo));
        arrayAdapterPeriodo.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerPeriodo.setAdapter(arrayAdapterPeriodo);

        spinnerUnidade = findViewById(R.id.spinner_unidade);
        ArrayAdapter<String> arrayAdapterUnidade = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.unidade));
        arrayAdapterUnidade.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerUnidade.setAdapter(arrayAdapterUnidade);

        editTextNota = findViewById(R.id.editTextInput_nota);
    }

    public void salvarNota(View view) {
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    //Metodo para voltar para a tela inicial do app
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
