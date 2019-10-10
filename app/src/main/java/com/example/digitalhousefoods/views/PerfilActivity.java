package com.example.digitalhousefoods.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.digitalhousefoods.R;
import com.google.android.material.textfield.TextInputLayout;

public class PerfilActivity extends AppCompatActivity {

    private TextInputLayout txtNome;
    private TextInputLayout txtEmail;
    private TextInputLayout txtSenha;
    private TextInputLayout txtRepetirSenha;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        txtNome = findViewById(R.id.txtNome);
        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        txtRepetirSenha = findViewById(R.id.txtRepetirSenha);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = txtNome.getEditText().getText().toString();
                String email = txtEmail.getEditText().getText().toString();
                String senha = txtSenha.getEditText().getText().toString();
                String repetirsenha = txtRepetirSenha.getEditText().getText().toString();

                if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !repetirsenha.isEmpty()) {
                    Intent intent = new Intent(PerfilActivity.this, HomeActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (nome.isEmpty()) {
                    txtNome.setError("Preencha o campo nome!");
                } else if (email.isEmpty()) {
                    txtEmail.setError("Preencha o campo e-mail!");
                } else if (senha.isEmpty()) {
                    txtSenha.setError("Preencha o campo senha!");
                } else {
                    txtRepetirSenha.setError("Preencha o campo repetir senha!");
                }
            }
        });
    }
}
