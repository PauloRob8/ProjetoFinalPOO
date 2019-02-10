package com.example.paulo_000.readerdiary.Model;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;



@Entity
public class Usuario {

    @Id
    private long id;
    private String nome;
    private String email;
    private String senha;
    private List<Livro> livros = new ArrayList<Livro>();
    private boolean cadastrado;

    public boolean isCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Usuario(String nome,String email,String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void addLivro(Livro livro){
        this.livros.add(livro);

    }

    public void avaliarLivro(Livro livro,float nota){
        livro.setNotaDeAvaliação(nota);
    }

    public void removerLivro(Livro livro){
        this.livros.remove(livro);
    }


    public int cadastraUsuario(Box<Usuario> usuarioBox){
        List<Usuario> result = usuarioBox.query().equal(Usuario_.email,this.email).build().find();
        return result.size();


    }

    public List<Usuario> logaUsuario(Box<Usuario> usuarioBox,String email,String senha){
        List<Usuario> result = usuarioBox.query()
                .equal(Usuario_.email,email)
                .equal(Usuario_.senha,senha)
                .build().find();
        return result;

    }
}