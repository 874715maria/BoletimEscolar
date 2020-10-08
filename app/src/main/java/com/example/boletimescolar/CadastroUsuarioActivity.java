package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private ImageButton imageButton_voltarMainActivity;
    private Button button_salvarCadastro;
    private EditText inputText_Nome, inputText_Email, inputText_Password;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        inicializarFirebase();

        imageButton_voltarMainActivity = (ImageButton) findViewById(R.id.imageButton_voltarMainActivity);
        button_salvarCadastro = (Button) findViewById(R.id.button_salvarCadastro);
        button_salvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
        inputText_Nome = (EditText) findViewById(R.id.inputText_Nome);
        inputText_Email = (EditText) findViewById(R.id.inputText_email);
        inputText_Password = (EditText) findViewById(R.id.inputText_password);


    }
    public void inicializarFirebase(){
        FirebaseApp.initializeApp(CadastroUsuarioActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void salvar(){
        Aluno aluno = new Aluno();
        aluno.setId(UUID.randomUUID().toString());
        aluno.setNome(inputText_Nome.getText().toString());
        aluno.setEmail(inputText_Email.getText().toString());
        aluno.setPassword(inputText_Password.getText().toString());

        databaseReference.child("Aluno").child(aluno.getId()) .setValue(aluno);
        limparCampos();
    }
    public void limparCampos(){
        inputText_Nome.setText("");
        inputText_Email.setText("");
        inputText_Password.setText("");
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity(View view) {
        finish();
    }

    //Metodo para enviar os dados do cadastro para o BD e ir para a tela início do app (não logado/tela de cadastro e login)
    public void salvarCadastro() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}