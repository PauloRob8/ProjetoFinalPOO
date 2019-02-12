package com.example.paulo_000.readerdiary;

import com.example.paulo_000.readerdiary.Model.Capitulo;
import com.example.paulo_000.readerdiary.Model.Comentario;
import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Model.Usuario;
import com.example.paulo_000.readerdiary.Services.GerenciadorLivro;
import com.example.paulo_000.readerdiary.Services.GerenciadorUsuario;

public class Teste {

    public static void main(String args[]) {


       Usuario usuario = new Usuario("Paulo","paulo.rob@gmail.com","123");
       Livro livro1 = new Livro("O Senhor Dos Aneis","J.R.R Tolkien","Fantasia","1920","Lendo","400");
       Capitulo capitulo = new Capitulo(1,"emocionante","Dificuldades na Jornada");

       GerenciadorLivro gerenciadorLivro = new GerenciadorLivro(usuario,livro1);

       //Adiciona um livro preenchendo suas informções
       usuario.addLivro("Game of Thrones","R.R Martin","Fantasia","2012","Desejo Ler","800");

       //Adiciona um livro ja criado
        usuario.addLivro(livro1);

        //Verifica a existência de um livro do usuario eo retorna
        System.out.println(gerenciadorLivro.obtemLivro("Game of Thrones"));

        usuario.inicarLeitura(gerenciadorLivro.obtemLivro("Game of Thrones"),"12/02/2018","500");
        usuario.terminarLeitura(livro1,"15/06/2014","20/08/2015");
        usuario.avaliarLivro(livro1,5.0f);
        usuario.editarLivro(livro1,"O Silmarillion","J.R.R Tolkien","Fantasia","1900","Lido","300");

        livro1.addCapitulo(1,"O inicio da aventura","Capitulo de introdução do livro");
        livro1.addCapitulo(capitulo);
        livro1.editarCapitulo(capitulo,2,"Problemas na jornada","Lendo este capitulo,comecei gostar mais de magos");

        //favorita um capitulo
        capitulo.favoritarCap();
        //Marca um capitulo para sinalizar que foi onde a leitura parou,ou simplesmente para sinalizar algo que o Leitor conseidere importante.
        capitulo.marcarCapitulo();

        //Gerenciador de livro tem a função de captu
        livro1.comentar("Leitura boa e agradável até o momento");
        gerenciadorLivro.obtemLivro("O Silmarillion");
        gerenciadorLivro.obtemCapitulo("O inicio da aventura");



    }
}
