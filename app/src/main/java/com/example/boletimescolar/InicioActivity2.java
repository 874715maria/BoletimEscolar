package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class InicioActivity2 extends AppCompatActivity {



    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_teste, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_materias:
                Toast.makeText(this, "Item Materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cadastrar_materia:
                abreCadastrarMateria();
                return true;
            case R.id.consulta_materia:
                abreConsultaMateria();
                return true;
            case R.id.action_contaUsuario:
                Toast.makeText(this, "Item Conta Usuario selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_sair:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void abreCadastrarMateria() {
        Intent intent = new Intent(this, MateriaActivity.class);
        startActivity(intent);
    }

    public void abreConsultaMateria() {
        Intent intent = new Intent(this, ListaMaterias.class);
        startActivity(intent);
    }

    /*public void abreCadastrarNota() {
        Intent intent = new Intent(this, CadastroNotaActivity.class);
        startActivity(intent);

    /*private void alterarMateria() {
        Intent intent = new Intent(getApplicationContext(), Materia.class);
        intent.putExtra("materiaId", materiaEscolhida.getId());
        intent.putExtra("materiaNome", materiaEscolhida.getNome());
        startActivity(intent);
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = Conexao.getFirebaseAuth();
        firebaseUser = Conexao.getFirebaseUser();
        virificaUser();
    }
    private void virificaUser() {
        if (firebaseUser == null) {
            finish();
        }
    }
    public void logout() {
        Conexao.logOut();
        finish();
    }
}