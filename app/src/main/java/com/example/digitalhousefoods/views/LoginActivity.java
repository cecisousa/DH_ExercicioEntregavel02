package com.example.digitalhousefoods.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.digitalhousefoods.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout campoEmail;
    private TextInputLayout campoSenha;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail = findViewById(R.id.txtEmail);
        campoSenha = findViewById(R.id.txtSenha);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = campoEmail.getEditText().getText().toString();
                String senha = campoSenha.getEditText().getText().toString();

                if (!email.isEmpty() && !senha.isEmpty()) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (email.isEmpty()) {
                    campoEmail.setError("Prencha o campo e-mail!");
                } else {
                    campoSenha.setError("Preencha o campo senha!");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });

    }
}
