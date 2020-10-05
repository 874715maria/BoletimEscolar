package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //private ListView listViewAluno;

   // private Button CadastrarUsuario;
   // private Button CadastrarMateria;
  //  private Button CadastrarNota;

    //private Button Salvar;
    //private Button Cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);

        //this.listViewAluno = (ListView) findViewById(R.id.listViewAluno);
        //this.listViewAluno.setAdapter(new AlunoAdapter(this,new Aluno().getLista()));


        //CadastrarUsuario = (Button) findViewById(R.id.CadastrarUsuario);
       // CadastrarMateria = (Button) findViewById(R.id.CadastrarMateria);
        //CadastrarNota = (Button) findViewById(R.id.CadastrarNota);//

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


      public void abreCadastrarUsuario (View view){
            Intent intent = new Intent(this, UsuarioActivity.class);
            startActivity(intent);
     }

      public void abreCadastrarMateria (View view){
          Intent intent = new Intent(this,MateriaActivity.class);
          startActivity(intent);
      }
    public void abreCadastrarNota (View view){
        Intent intent = new Intent(this,NotaActivity.class);
        startActivity(intent);
    }
}

