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
   public void chamarTelaLogin(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    public void chamarTelaCadastro(View view) {
        Intent intent = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intent);
    }
}