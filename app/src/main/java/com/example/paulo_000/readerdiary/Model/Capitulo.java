package com.example.paulo_000.readerdiary.Model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Capitulo {
    @Id
    private long   id;
    private String titulo;
    private int capNum;
    private String descricao;
    private ToOne<Livro> livro;
    private boolean favorito = false;
    private boolean marcado = false; //Marca o capitulo em que o leitor está


    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public int getCapNum() {
        return capNum;
    }

    public void setCapNum(int capNum) {
        this.capNum = capNum;
    }

    public ToOne<Livro> getLivro() {
        return livro;
    }

    public void setLivro(ToOne<Livro> livro) {
        this.livro = livro;
    }

    public long getId() {
        return id;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   public Capitulo(int capNum,String descricao,String titulo){
        this.capNum = capNum;
        this.descricao = descricao;
        this.titulo = titulo;
   }
    public Capitulo(){

    }

    public boolean favoritarCap(){

        this.favorito = !this.favorito;

        return this.favorito;
    }

    public boolean marcarCapitulo(){
        this.marcado = !this.marcado;

        return this.marcado;
    }
}
