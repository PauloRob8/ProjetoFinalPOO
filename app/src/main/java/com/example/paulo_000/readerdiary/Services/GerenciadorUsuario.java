package com.example.paulo_000.readerdiary.Services;


import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Model.Usuario;

import java.util.ArrayList;
import java.util.List;


public class GerenciadorUsuario {

    private Usuario usuario;
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public GerenciadorUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public GerenciadorUsuario(){

    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public int cadastrarUsuario(List<Usuario> usuarios){
        if(obtemUsuario(usuarios) != null){
            return -1;
        }
        else
            return 1;

    }

    public int logarUsuario(List<Usuario> usuarios,String email,String senha){
       if(obtemUsuarioCadastrado(usuarios,email,senha) != null){
           return 1;
       }
       else
           return -1;
    }


    public void addLivroDeInteresse(String titulo,String autor,String genero,String ano,String status,String quantidadeDePg){
        usuario.getLivros().add(new Livro(titulo,autor,genero,ano,"Desejo Ler",quantidadeDePg));

    }

    public Usuario obtemUsuario(List<Usuario> usuarios){
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getEmail().equals(this.usuario.getEmail())){
                return usuarios.get(i);
            }


        }
        return null;
    }

    public Usuario obtemUsuarioCadastrado(List<Usuario> usuarios,String email,String senha){
        for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getEmail().equals(email) && usuarios.get(i).getSenha().equals(senha)){
                return usuarios.get(i);
            }
        }
        return null;
    }

}
