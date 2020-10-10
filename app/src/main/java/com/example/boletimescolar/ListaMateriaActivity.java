package com.example.boletimescolar;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaMateriaActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    private ImageButton imageButton;
    private Button buttonApagar, buttonEditar;

    private List<Materia> listaMaterias = new ArrayList<Materia>();
    private ArrayAdapter<Materia> arrayAdapterMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_materia);

        inicializarFirebase();
       eventoDatabase();

        imageButton = (ImageButton) findViewById(R.id.imageButton_voltarMainActivity);

        buttonApagar = (Button) findViewById(R.id.buttonApagar);
        buttonEditar = (Button) findViewById(R.id.buttonEditar);
    }
    public void voltar(View view){
    finish();
    }
    public void inicializarFirebase(){
        FirebaseApp.initializeApp(ListaMateriaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }
    private void eventoDatabase() {
        databaseReference.child("Materia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaMaterias.clear();
                for(DataSnapshot objSnapshot:dataSnapshot.getChildren()){
                    Materia materia = objSnapshot.getValue(Materia.class);
                    listaMaterias.add(materia);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}