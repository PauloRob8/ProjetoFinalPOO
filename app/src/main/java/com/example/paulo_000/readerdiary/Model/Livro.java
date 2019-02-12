package com.example.paulo_000.readerdiary.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Livro {


    private ToOne<Usuario> dono;
    @Id
    private long id;

    private String titulo;
    private String autor;
    private String genero;
    private String ano;

    private String qtdPg;
    private String pgAtual;
    private String status;
    private String dataInicial;
    private String dataFinal;
    private List<Comentario> comentarios = new ArrayList<Comentario>();
    private List<Capitulo> capitulos = new ArrayList<Capitulo>();
    private float notaDeAvaliação;

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public float getNotaDeAvaliação() {
        return notaDeAvaliação;
    }

    public void setNotaDeAvaliação(float notaDeAvaliação) {
        this.notaDeAvaliação = notaDeAvaliação;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getPgAtual() {
        return pgAtual;
    }

    public void setPgAtual(String pgAtual) {
        this.pgAtual = pgAtual;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getQtdPg() {
        return qtdPg;
    }

    public void setQtdPg(String qtdPg) {
        this.qtdPg = qtdPg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public ToOne<Usuario> getDono() {
        return dono;
    }

    public void setDono(ToOne<Usuario> dono) {
        this.dono = dono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Livro(){

    }

    public Livro(String titulo,String autor,String genero,String ano,String status,String numeroDePg){
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
        this.status = status;
        this.qtdPg =numeroDePg;

    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }


   public void addCapitulo(Capitulo capitulo){
        this.capitulos.add(capitulo);
   }

   public void addCapitulo(int numCap,String titulo,String descr){
        this.capitulos.add(new Capitulo(numCap,titulo,descr));
   }

   public void editarCapitulo(Capitulo capitulo,int numCap,String titulo,String descr){
        capitulo.setCapNum(numCap);
        capitulo.setTitulo(titulo);
        capitulo.setDescricao(descr);

   }

    public void comentar(String comentario){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Comentario comentario1 = new Comentario(comentario,dateFormat.format(date));
        this.getComentarios().add(comentario1);
    }


    public void validaPag(String qtdPg,String pgAtual){
        if(!pgAtual.equals("") & !qtdPg.equals("")) {
            if (Integer.parseInt(pgAtual) > Integer.parseInt(qtdPg)) {
                this.setPgAtual(qtdPg);
            }
        }
    }

}
