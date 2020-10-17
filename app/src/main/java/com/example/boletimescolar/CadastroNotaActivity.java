package com.example.boletimescolar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CadastroNotaActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView textView_cadastroNota;
    private EditText editText_nomeMateria, editText_periodo, editText_unidade, editText_nota;
    private Button button_cancelar, button_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_nota);
        inicializarFirebase();

        textView_cadastroNota = findViewById(R.id.cadastrar_nota);
        editText_nomeMateria = findViewById(R.id.editTextInput_nomeMateria);
        editText_periodo = findViewById(R.id.editTextInput_periodo);
        editText_unidade = findViewById(R.id.editTextInput_unidade);
        editText_nota = findViewById(R.id.editTextInput_nota);

        button_cancelar = findViewById(R.id.button_Cancelar);
        button_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarMainActivity(view);
            }
        });

        button_salvar = findViewById(R.id.button_Salvar);
        button_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        String[] unidade = getResources().getStringArray(R.array.unidade);
    }

    public void inicializarFirebase() {
        FirebaseApp.initializeApp(CadastroNotaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void salvar() {
        Materia materia = new Materia();
        materia.setId(UUID.randomUUID().toString());
        materia.setNome(editText_nomeMateria.getText().toString());
        databaseReference.child("Materia").child(materia.getId()).setValue(materia);
        limparCampos();
    }

    public void limparCampos() {
        editText_nomeMateria.setText("");
    }

    public void voltarMainActivity(View view) {
        finish();
    }
}