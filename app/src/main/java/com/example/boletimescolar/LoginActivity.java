package com.example.boletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private ImageButton imageButton_voltarMainActivity;
    private Button button_entrar;
    private EditText inputText_email, inputText_password;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button_entrar = (Button) findViewById(R.id.button_entrar);
        button_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputText_email.getText().toString().trim();
                String password = inputText_password.getText().toString().trim();
                login(email, password);
            }
        });
        imageButton_voltarMainActivity = (ImageButton) findViewById(R.id.button_voltarMainActivityLogin);

        inputText_email = (EditText) findViewById(R.id.inputText_email);
        inputText_password = (EditText) findViewById(R.id.inputText_password);
    }

    private void login(String email, String password) {
        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(LoginActivity.this, InicioActivity2.class);
                                startActivity(intent);
                            }else{
                                alert("e-mail ou senha errados");
                            }
                    }
                });
    }

    private void alert(String s) {
        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    //Metodo para voltar para a tela inicial do app (não logado/tela de cadastro e login)
    public void voltarMainActivity(View view) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }
}