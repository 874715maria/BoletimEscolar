package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

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

        buttonSalvar =  (Button) findViewById(R.id.buttonSalvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
                salvarMateria();
            }
        });
        buttonCancelar = (Button) findViewById(R.id.buttonCancelar);

        editTextTextPersonName = (EditText) findViewById(R.id.editText_nomeMateria);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_materias:
                Toast.makeText(this, "Item Materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cadastrar_materia:
                Toast.makeText(this, "Item Cadastrar materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cadastrar_nota:
                Toast.makeText(this, "Item Cadastrar Nota Selecionado selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_notas:
                Toast.makeText(this, "Item Nota selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.consulta_materia:
                Toast.makeText(this, "Item Consultar Materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.consulta_boletim:
                Toast.makeText(this, "Item Consultar Boletim selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_contaUsuario:
                Toast.makeText(this, "Item Conta Usuario selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_sair:
                Toast.makeText(this, "Item Sair selecionado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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