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

    public Usuario(){

    }

    //Para caso o livro seja apenas classificado como "Desejo Ler"
    public void editarLivro(Livro livro,String titulo,String autor,String genero,String ano,String status,String numeroDePg) {
        livro.setTitulo(titulo);
        livro.setAno(ano);
        livro.setGenero(genero);
        livro.setAutor(autor);
        livro.setStatus(status);
        livro.setQtdPg(numeroDePg);
        this.livros.add(livro);

    }
    //Caso o livro esteja classificado como lendo
    public void editarLivro(Livro livro,String titulo,String autor,String genero,String ano,String status,String numeroDePg,String dataInicial,String pgAtual) {
        livro.setTitulo(titulo);
        livro.setAno(ano);
        livro.setGenero(genero);
        livro.setAutor(autor);
        livro.setStatus(status);
        livro.setQtdPg(numeroDePg);
        livro.setPgAtual(pgAtual);
        livro.setDataInicial(dataInicial);
        this.livros.add(livro);

    }

    //Caso o livro esteja classificado como lido
    public void editarLivro(Livro livro,String titulo,String autor,String genero,String ano,String status,String numeroDePg,String paginaAtual,String dataInicial,String datafinal) {
        livro.setTitulo(titulo);
        livro.setAno(ano);
        livro.setGenero(genero);
        livro.setAutor(autor);
        livro.setStatus(status);
        livro.setQtdPg(numeroDePg);
        livro.setPgAtual(paginaAtual);
        livro.setDataInicial(dataInicial);
        livro.setDataFinal(datafinal);
        this.livros.add(livro);

    }


    public void inicarLeitura(Livro livro,String dataDeInicio,String paginaAtual){
        livro.setStatus("Lendo");
        livro.setDataInicial(dataDeInicio);
        livro.setPgAtual(paginaAtual);
    }

    public void terminarLeitura(Livro livro,String dataInicial,String dataFinal){
        livro.setStatus("Lido");
        livro.setDataInicial(dataInicial);
        livro.setDataFinal(dataFinal);
    }

    public void addLivro(Livro livro){
        this.livros.add(livro);
    }

    public void addLivro(String titulo,String autor,String genero,String ano,String status,String numeroDePg){
        this.livros.add(new Livro(titulo,autor,genero,ano,status,numeroDePg));

    }


    public void avaliarLivro(Livro livro,float nota){
        livro.setNotaDeAvaliação(nota);
    }


   // public int logaUsuario(List<Usuario> usuarios){
     //   for(int i = 0; i < usuarios.size(); i++){


    public List<Usuario> logaUsuario(Box<Usuario> usuarioBox,String email,String senha){
        List<Usuario> result = usuarioBox.query()
                .equal(Usuario_.email,email)
                .equal(Usuario_.senha,senha)
                .build().find();
        return result;

    }
}