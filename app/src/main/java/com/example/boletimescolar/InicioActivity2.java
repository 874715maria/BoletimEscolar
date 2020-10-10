package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InicioActivity2 extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_teste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_materias:
                Toast.makeText(this, "Item Materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cadastrar_materia:
                abreCadastrarMateria();
                return true;
            case R.id.consulta_materia:
                abreConsultaMateria();
                return true;
            case R.id.action_notas:
                return true;
            case R.id.cadastrar_nota:
                //abreCadastrarNota();
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
     public void abreCadastrarMateria() {
        Intent intent = new Intent(this, MateriaActivity.class);
        startActivity(intent);
    }
    public void abreConsultaMateria(){
        Intent intent = new Intent(this, ListaMateriaActivity.class);
        startActivity(intent);
    }

    /*public void abreCadastrarNota() {
        Intent intent = new Intent(this, NotaActivity.class);
        startActivity(intent);
    }*/
    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem mAlterar = menu.add("Alterar Materia");
        MenuItem mDeletar = menu.add("Deletar Materia");

        mAlterar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                alterarMateria();
                return false;
            }
        });
        super.onCreateContextMenu(menu, v, menuInfo);
    }
*/
    /*private void alterarMateria() {
        Intent intent = new Intent(getApplicationContext(), Materia.class);
        intent.putExtra("materiaId", materiaEscolhida.getId());
        intent.putExtra("materiaNome", materiaEscolhida.getNome());
        startActivity(intent);
    }*/
   /* private void bancoDeDados() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        materialist = new ArrayList<>();

        databaseReference.child("Materia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                materialist.clear();
                for(DataSnapshot obj: dataSnapshot.getChildren()){
                    Materia m = obj.getValue(Materia.class);
                    materialist.add(m);
                }
                materiaAdapter = new MateriaAdapter(getApplicationContext(),materialist);
                listView.setAdapter(materiaAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = Conexao.getFirebaseAuth();
        firebaseUser = Conexao.getFirebaseUser();
        virificaUser();
    }

    private void virificaUser() {
        if (firebaseUser == null){
            finish();
        }
    }
    public void logout(){
        Conexao.logOut();
        finish();
    }
}