package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonEntrar, buttonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEntrar = (Button) findViewById(R.id.button_entrar);
        buttonRegistrar = (Button) findViewById(R.id.button_registrarUsuario);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_materias:
                Toast.makeText(this, "Item Materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cadastrar_materia:
                Toast.makeText(this, "Item Cadastrar materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cadastrar_nota:
                Toast.makeText(this, "Item Cadastrar Nota Selecionado selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_notas:
                Toast.makeText(this, "Item Nota selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.consulta_materia:
                Toast.makeText(this, "Item Consultar Materia selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.consulta_boletim:
                Toast.makeText(this, "Item Consultar Boletim selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_contaUsuario:
                Toast.makeText(this, "Item Conta Usuario selecionado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_sair:
                Toast.makeText(this, "Item Sair selecionado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
   public void chamarTelaLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void chamarTelaCadastro(View view) {
        Intent intent = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intent);
    }
}