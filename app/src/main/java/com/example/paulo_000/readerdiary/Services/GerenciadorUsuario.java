package com.example.paulo_000.readerdiary.Services;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Model.Usuario;

import io.objectbox.Box;


public class GerenciadorUsuario {

    private Usuario usuario;

    public GerenciadorUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public int cadastrarUsuario(Usuario usuario, String email, String senha, Box<Usuario> usuarioBox) {
        if (!email.trim().isEmpty() && !senha.trim().isEmpty())
            if (usuario.cadastraUsuario(usuarioBox) == 0) {
                usuario.setCadastrado(true);
                usuarioBox.put(usuario);
                return 1;
            } else {
               return -1;
            }
        else
            return 0;

    }

    public void addLivroDeInteresse(String titulo,String autor,String genero,String ano,String status,String quantidadeDePg){
        usuario.getLivros().add(new Livro(titulo,autor,genero,ano,"Desejo Ler",quantidadeDePg));

    }

}
