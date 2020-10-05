package com.example.boletimescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaActivity2 extends AppCompatActivity {

    private Aluno aluno;
    private EditText editTextNome;
    private EditText editTextIdade;
    private EditText editTextEmail;
    private EditText editTextNomeEscola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        this.aluno = new Aluno();
        this.editTextNome = (EditText) findViewById(R.id.editTextNome);
        this.editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        this.editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        this.editTextNomeEscola = (EditText) findViewById(R.id.editTextNomeEscola);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                    this.aluno.setId(bundle.getInt("id"));
                    this.editTextNome.setText(bundle.getString("nome"));
                    this.editTextIdade.setText(bundle.getString("idade"));
                    this.editTextEmail.setText(bundle.getString("email"));
                    this.editTextNomeEscola.setText(bundle.getString("nomeEscola"));
            }
        }
    }
    public void salvar (View view){
        this.aluno.setNome(this.editTextNome.getText().toString());
        this.aluno.setIdade(this.editTextIdade.getText().toString());
        this.aluno.setEmail(this.editTextEmail.getText().toString());
        this.aluno.setNomeEscola(this.editTextNomeEscola.getText().toString());
        this.aluno.salvar();

        Toast.makeText(this,this.aluno.getMensagem(),Toast.LENGTH_LONG).show();
        if (aluno.is_status())
            finish();
         }

         public void cancelar (View view){
            finish();
        }
}