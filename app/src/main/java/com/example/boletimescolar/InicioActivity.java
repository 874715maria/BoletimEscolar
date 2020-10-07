package com.example.boletimescolar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InicioActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cadastrar_materia) {
            Toast.makeText(getApplicationContext(), "botão cadastro de matéira em execução", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.cadastrar_nota) {
            Toast.makeText(getApplicationContext(), "botão cadastro de boletim em execução", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.consulta_materia) {
            Toast.makeText(getApplicationContext(), "botão consulta de matéria em execução", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.consulta_bolatim) {
            Toast.makeText(getApplicationContext(), "botão consulta de boletim em execução", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_sair) {
            Toast.makeText(getApplicationContext(), "Sair Clicado", Toast.LENGTH_LONG).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void abreCadastrarMateria(View view) {
        Intent intent = new Intent(this, MateriaActivity.class);
        startActivity(intent);
    }

    public void abreCadastrarNota(View view) {
        Intent intent = new Intent(this, NotaActivity.class);
        startActivity(intent);
    }
}