package com.example.boletimescolar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        buttonSalvar = (Button) findViewById(R.id.buttonSalvar);
        buttonCancelar = (Button) findViewById(R.id.buttonCancelar);

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextNomeEscola = (EditText) findViewById(R.id.editTextNomeEscola);
    }
    public void salvarUsuario(View view) {
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity(View view) {
       finish();
    }
    /*public void salvar (View view){
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
        }*/
}