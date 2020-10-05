package com.example.boletimescolar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.boletimescolar.R.menu.menu_main;

public class MateriaActivity extends AppCompatActivity {

    private Materia materia;
    private EditText editTextTextPersonName;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_materia);
        setContentView(menu_main);

        this.materia = new Materia();
        this.editTextTextPersonName = (EditText) findViewById(R.id.editTextTextPersonName);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                this.materia.setId(bundle.getInt("id"));
                this.editTextTextPersonName.setText(bundle.getString("nome"));
            }
        }
    }
    public void salvar (View view){
        this.materia.setNome(this.editTextTextPersonName.getText().toString());
        this.materia.salvar();

        Toast.makeText(this,this.materia.getMensagem(),Toast.LENGTH_LONG).show();
        if (materia.is_status())
            finish();
    }

    public void cancelar (View view){
        finish();
    }
}