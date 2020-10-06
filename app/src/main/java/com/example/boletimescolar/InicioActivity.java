package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity {

    private Button buttonCadastrarUsuario;
    private Button buttonCadastrarMateria;
    private Button buttonCadastrarNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        buttonCadastrarUsuario = (Button) findViewById(R.id.CadastrarUsuario);
        buttonCadastrarMateria = (Button) findViewById(R.id.CadastrarMateria);
        buttonCadastrarNota = (Button) findViewById(R.id.CadastrarNota);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cadastro_materia) {
            Toast.makeText(getApplicationContext(), "botão cadastro de matéira em execução", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.cadastro_bolatim) {
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

    public void abreCadastrarUsuario(View view) {
        Intent intent = new Intent(this, UsuarioActivity.class);
        startActivity(intent);
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