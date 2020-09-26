package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Aluno aluno;

    private TextView TextViewNome;
    private TextView TextViewIdade;
    private TextView TextViewEmail;
    private TextView TextViewNomeEscola;

    private ListView listViewAluno;

    private Button CadastrarUsuario;
    private Button CadastrarMateria;
    private Button CadastrarNota;

    private Button Salvar;
    private Button Cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_novo);
        setContentView(R.layout.activity_list);

        this.listViewAluno = (ListView) findViewById(R.id.listViewAluno);
        this.listViewAluno.setAdapter(new AlunoAdapter(this,new Aluno().getLista()));

        this.aluno = new Aluno();

        this.TextViewNome = (TextView) findViewById(R.id.textViewNome);
        this.TextViewIdade = (TextView) findViewById(R.id.textViewIdade);
        this.TextViewEmail = (TextView) findViewById(R.id.textViewEmail);
        this.TextViewNomeEscola = (TextView) findViewById(R.id.textViewNomeEscola);

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getExtras();
            if (bundle != null){
                this.aluno.setId(bundle.getInt("id"));
                this.TextViewNome.setText(bundle.getString("nome"));
                this.TextViewIdade.setText(bundle.getString("idade"));
                this.TextViewEmail.setText(bundle.getString("email"));
                this.TextViewNomeEscola.setText(bundle.getString("nomeEscola"));
            }
        }

        CadastrarUsuario = (Button) findViewById(R.id.CadastrarUsuario);
        CadastrarMateria = (Button) findViewById(R.id.CadastrarMateria);
        CadastrarNota = (Button) findViewById(R.id.CadastrarNota);

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
    public void salvar (View view){
        this.aluno.setNome(this.TextViewNome.getText().toString());
        this.aluno.setIdade(this.TextViewIdade.getText().toString());
        this.aluno.setEmail(this.TextViewEmail.getText().toString());
        this.aluno.setNomeEscola(this.TextViewNomeEscola.getText().toString());
        this.aluno.salvar();

        Toast.makeText(this,this.aluno.getMensagem(),Toast.LENGTH_LONG).show();
        if (aluno.is_status())
            finish();
    }

    public void cancelar (View view){
        finish();
    }

    public void abreCadastrarAluno (View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void abreLista (View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

