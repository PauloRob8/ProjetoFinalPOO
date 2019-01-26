package com.example.paulo_000.readerdiary.Model;

import com.example.paulo_000.readerdiary.Model.Livro;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Capitulos {
    @Id
    private long   id;
    private String titulo;
    private int capNum;
    private ToOne<Livro> livro;

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

    public void setId(long id) {
        this.id = id;
    }

    private String comentario;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void salvaCapitulo(String titulo,String comentario,int numero){
        this.setTitulo(titulo);
        this.setComentario(comentario);
        this.setCapNum(numero);

    }
}
