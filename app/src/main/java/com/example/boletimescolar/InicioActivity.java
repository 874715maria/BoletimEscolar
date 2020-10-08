package com.example.boletimescolar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class InicioActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    //FirebaseDatabase firebaseDatabase;
    //DatabaseReference databaseReference;

   // private ListView listView;
   // private StorageReference storageReference;

    //private List<Materia> materialist;
   // private MateriaAdapter materiaAdapter;

    //private Materia materia;
    private TextView textEmail, textId;

    private EditText editTextTextPersonName;

    //private Materia materiaEscolhida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
       // bancoDeDados();
       // registerForContextMenu(listView);

        textEmail = (TextView) findViewById(R.id.textEmail);
        textId = (TextView) findViewById(R.id.textId);
    }

    public void abreCadastrarMateria(View view) {
        Intent intent = new Intent(this, MateriaActivity.class);
        startActivity(intent);
    }

    public void abreCadastrarNota(View view) {
        Intent intent = new Intent(this, NotaActivity.class);
        startActivity(intent);
    }
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
        }else {
            textEmail.setText("Email: "+ firebaseUser.getEmail());
            textId.setText("ID: "+ firebaseUser.getUid());
        }
    }
    public void logout(){
        Conexao.logOut();
        finish();
    }
}