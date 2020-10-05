package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NotaActivity extends AppCompatActivity {

    private Nota nota;
    private EditText editTextPeriodo;
    private EditText editTextUnidade;
    private EditText editTextNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadasto_nota);

        this.nota = new Nota();
        this.editTextPeriodo = (EditText) findViewById(R.id.editTextPeriodo);
        this.editTextUnidade = (EditText) findViewById(R.id.editTextUnidade);
        this.editTextNota = (EditText) findViewById(R.id.editTextNota);

        Intent intent = getIntent();
        if(intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                this.nota.setId(bundle.getInt("id"));
                this.editTextPeriodo.setText(bundle.getString("periodo"));
                this.editTextUnidade.setText(bundle.getString("unidade"));
                this.editTextNota.setText(bundle.getString("nota"));
            }
        }
    }
    public void salvar (View view){
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
    }
}
