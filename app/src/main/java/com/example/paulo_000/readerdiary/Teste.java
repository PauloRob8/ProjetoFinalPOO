package com.example.paulo_000.readerdiary;

import com.example.paulo_000.readerdiary.Model.Capitulo;
import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Model.Usuario;
import com.example.paulo_000.readerdiary.Services.GerenciadorLivro;
import com.example.paulo_000.readerdiary.Services.GerenciadorUsuario;

public class Teste {

    public static void main(String args[]) {

        Livro livro = new Livro("Game of Thrones", "R.R. Martin", "Fantasia", "2012", "Desejo Ler", "800");
        Usuario usuario = new Usuario("Paulo", "paulo@hotmail.com", "123");
        Capitulo capitulos = new Capitulo(1, "Este capitulo foi incrivel", "Introdução");
        GerenciadorLivro livro1 = new GerenciadorLivro(livro);
        GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario(usuario);

        usuario.addLivro(livro);
        usuario.terminarLeitura(livro, "11/02/2018", "11/03/2018");
        usuario.avaliarLivro(livro, 5.0f);
        livro.addCapitulo(capitulos);
        livro1.comentar("Bom livro,emocionante e intrigante");
    }
}
