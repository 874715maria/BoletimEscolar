package com.example.boletimescolar;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.boletimescolar.R.menu.menu_main;

public class MateriaActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private Button buttonSalvar, buttonCancelar;

    private EditText editTextTextPersonName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_materia);
        inicializarFirebase();
        getMateriaEnviado();

        buttonSalvar =  (Button) findViewById(R.id.buttonSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
                salvarMateria();
            }
        });
        buttonCancelar = (Button) findViewById(R.id.buttonCancelar);

        editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);

    }

    private void getMateriaEnviado() {
    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(MateriaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void salvar(){
        Materia materia = new Materia();
        materia.setId(UUID.randomUUID().toString());
        materia.setNome(editTextTextPersonName.getText().toString());

        databaseReference.child("Materia").child(materia.getId()) .setValue(materia);
        limparCampos();
    }
    public void limparCampos(){
        editTextTextPersonName.setText("");
    }
    public void salvarMateria() {
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