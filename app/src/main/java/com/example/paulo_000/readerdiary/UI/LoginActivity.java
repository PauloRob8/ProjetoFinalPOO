package com.example.paulo_000.readerdiary.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paulo_000.readerdiary.Model.Usuario;
import com.example.paulo_000.readerdiary.Model.Usuario_;
import com.example.paulo_000.readerdiary.Persistencia.App;
import com.example.paulo_000.readerdiary.R;


import java.util.List;

import io.objectbox.Box;

public class LoginActivity extends AppCompatActivity {

    public TextView appTitle;
    public EditText editEmail;
    public EditText editSenha;
    public Box<Usuario> usuarioBox;
    public Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        setupViews();
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);

    }

    private void setupViews() {

        appTitle = findViewById(R.id.readerDiary);
        Typeface font = Typeface.createFromAsset(getAssets(),"font2.TTF");
        appTitle.setTypeface(font);
        editEmail = findViewById(R.id.Lemail);
        editSenha = findViewById(R.id.Lsenha);

        editEmail.setTypeface(font);
        editSenha.setTypeface(font);
    }

    public void logar(View view) {
        String email = editEmail.getText().toString();
        String senha = editSenha.getText().toString();
        List<Usuario> result = usuarioBox.query()
                .equal(Usuario_.email, email)
                .equal(Usuario_.senha, senha)
                .build().find();

        if (!email.trim().isEmpty() && !senha.trim().isEmpty())
            if (result.size() > 0) {
                Toast.makeText(this,"Bem Vindo ao ReaderDiary",Toast.LENGTH_LONG ).show();
                carregaUsuario(result.get(0));
            } else {
                editSenha.getText().clear();
                Toast.makeText(this, "Email ou senha incorreto(s),Digite novamente", Toast.LENGTH_LONG).show();
            }
        else
            Toast.makeText(this,"Email ou senha não preenchido",Toast.LENGTH_LONG).show();
    }


    private void carregaUsuario(Usuario usuario) {
        SharedPreferences preferences = getSharedPreferences("readerdiary", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("usuarioId", usuario.getId());

        editor.apply();

        startActivity(new Intent(this, ListaLivrosActivity.class));
        finish();
    }

    public void moverParaCadastro(View view) {
       startActivity(new Intent(this,CadastroActivity.class));

    }
}


