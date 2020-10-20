package com.example.boletimescolar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MateriaActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private Button buttonSalvar, buttonCancelar, button_deletar, button_atualizar;

    ListView listV_dados;
    private List<Materia> listaMaterias = new ArrayList<Materia>();
    private ArrayAdapter<Materia> arrayAdapterMaterias;

    private String id;
    private TextView textView_preenchaCampo;
    private EditText inputText_nome, inputText_unidade, inputText_periodo, inputText_nota;
    private Materia materiaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_materia);
        inicializarFirebase();
        eventoDatabase();

        listV_dados = (ListView) findViewById(R.id.listV_dados);

        listV_dados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                materiaSelecionada = (Materia) parent.getItemAtPosition(position);
                inputText_nome.setText(materiaSelecionada.getNome());
                inputText_unidade.setText(materiaSelecionada.getUnidade());
                inputText_periodo.setText(materiaSelecionada.getPeriodo());
                inputText_nota.setText(materiaSelecionada.getNota());
            }
        });

        buttonSalvar =  (Button) findViewById(R.id.button_Salvar);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
        buttonCancelar = (Button) findViewById(R.id.button_Cancelar);

        textView_preenchaCampo = (TextView) findViewById(R.id.textView_PreenchaCampos);
        inputText_nome = (EditText) findViewById(R.id.editTextInput_nomeMateria);
        inputText_unidade = (EditText) findViewById(R.id.editTextInput_periodo);
        inputText_periodo = (EditText) findViewById(R.id.editTextInput_unidade);
        inputText_nota = (EditText) findViewById(R.id.editTextInput_nota);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_salvar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_atualizar){
            Materia m = new Materia();
            m.setId(materiaSelecionada.getId());
            m.setNome(inputText_nome.getText().toString().trim());
            m.setUnidade(inputText_unidade.getText().toString().trim());
            m.setPeriodo(inputText_periodo.getText().toString().trim());
            m.setNota(inputText_nota.getText().toString().trim());
            databaseReference.child("Materia").child(m.getId()).setValue(m);
            limparCampos();
        }else if(id == R.id.menu_deletar){
            Materia m = new Materia();
            m.setId(materiaSelecionada.getId());
            databaseReference.child("Materia").child(m.getId()).removeValue();
            limparCampos();
        }
        return true;
    }

    private void eventoDatabase() {
        databaseReference.child("Materia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaMaterias.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    Materia m = objSnapshot.getValue(Materia.class);
                    listaMaterias.add(m);
                }
                arrayAdapterMaterias = new ArrayAdapter<Materia>(MateriaActivity.this,
                        android.R.layout.simple_list_item_1,listaMaterias);
                listV_dados.setAdapter(arrayAdapterMaterias);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void inicializarFirebase(){
        FirebaseApp.initializeApp(MateriaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    public void salvar(){
        Materia materia = new Materia();
        materia.setId(UUID.randomUUID().toString());
        materia.setNome(inputText_nome.getText().toString());
        materia.setNome(inputText_unidade.getText().toString());
        materia.setNome(inputText_periodo.getText().toString());
        materia.setNome(inputText_nota.getText().toString());
        databaseReference.child("Materia").child(materia.getId()) .setValue(materia);
        limparCampos();
    }
    public void limparCampos(){
        inputText_nome.setText("");
        inputText_unidade.setText("");
        inputText_periodo.setText("");
        inputText_nota.setText("");
    }

    //Metodo para voltar para a tela inicial dos cadastros
    public void voltarMainActivity(View view) {
       finish();
    }
}