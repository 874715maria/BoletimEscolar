package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class CadastrarActivity extends AppCompatActivity {

    ImageView imageView_botaoVoltar;
    TextInputEditText textInputEditText_nome, textInputEditText_email, textInputEditText_senha;
    Button button_proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        button_proximo = findViewById(R.id.button_Salvar);
    }

    public void chamarTelaInicio(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    public void TelaIncial(){
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
}
