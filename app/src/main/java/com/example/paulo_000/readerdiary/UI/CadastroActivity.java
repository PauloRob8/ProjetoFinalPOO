package com.example.paulo_000.readerdiary.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulo_000.readerdiary.Model.Usuario;
import com.example.paulo_000.readerdiary.Persistencia.App;
import com.example.paulo_000.readerdiary.R;
import com.example.paulo_000.readerdiary.Services.GerenciadorUsuario;


import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;

public class CadastroActivity extends AppCompatActivity {

    private EditText cadastroEmail,cadastroSenha,nomeDoUsuario;
    private Box<Usuario> usuarioBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        setupViews();
    }

    public void setupViews(){
        cadastroEmail = findViewById(R.id.cd_email);
        cadastroSenha = findViewById(R.id.cd_senha);
        nomeDoUsuario = findViewById(R.id.cd_nome);
    }

    public void cadastrar(View view) {


        String nome = nomeDoUsuario.getText().toString();
        String email = cadastroEmail.getText().toString();
        String senha = cadastroSenha.getText().toString();
        Usuario usuario = new Usuario(nome,email,senha);

        List<Usuario> usuarioList = usuarioBox.getAll();

        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario(usuario);


        if (gerenciadorUsuario.cadastrarUsuario(usuarioList) == 1) {
            usuarioBox.put(usuario);
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            carregaUsuario(usuario);
        }
        else if(gerenciadorUsuario.cadastrarUsuario(usuarioList) == -1) {
            cadastroSenha.getText().clear();
            Toast.makeText(this, "Email já cadastrado.", Toast.LENGTH_LONG).show();
        }

        else
            Toast.makeText(this, "Email ou senha não preenchido cadastrado.", Toast.LENGTH_LONG).show();

    }
    private void carregaUsuario(Usuario usuario) {
        SharedPreferences preferences = getSharedPreferences("readerdiary", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("usuarioId", usuario.getId());

        editor.apply();

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void cancelar(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }
}
