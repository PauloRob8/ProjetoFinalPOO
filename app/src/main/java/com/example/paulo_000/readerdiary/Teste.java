package com.example.paulo_000.readerdiary;

import com.example.paulo_000.readerdiary.Model.Capitulo;
import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Model.Usuario;
import com.example.paulo_000.readerdiary.Services.GerenciadorLivro;

public class Teste {

    public static void main(String args[]){

        Livro livro = new Livro("Game of Thrones","R.R. Martin","Fantasia","2012","Desejo Ler","800");
        Usuario usuario = new Usuario("Paulo","paulo@hotmail.com","123");
        Capitulo capitulos = new Capitulo(1,"Este capitulo foi incrivel","Introdução");
        GerenciadorLivro livro1 = new GerenciadorLivro(livro);

       usuario.addLivro(livro);
       usuario.avaliarLivro(livro,5.0f);
       livro.addCapitulo(capitulos);
       livro1.comentar("Bom livro,emocionante e intrigante");

       System.out.println("Livro do " + usuario.getNome() + ": " + usuario.getLivros().get(0).getTitulo());
       System.out.println("Capitulo do livro " + livro.getTitulo() + ": "+ livro.getCapitulos().get(0).getTitulo() + " Descrição do cap: " +livro.getCapitulos().get(0).getDescricao());
       System.out.println("Comentaríos sobre o livro: " + livro.getComentarios().get(0).getDescricao() + " data: " +
               livro.getComentarios().get(0).getDataHora() + " Horas \n" +"nota: " + livro.getNotaDeAvaliação());

    }
}
