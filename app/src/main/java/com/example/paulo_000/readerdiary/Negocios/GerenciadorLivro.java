package com.example.paulo_000.readerdiary.Negocios;

import android.widget.EditText;
import android.widget.TextView;

import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.R;

public class GerenciadorLivro {

    private Livro livro;

    public GerenciadorLivro(Livro livro){
        this.livro = livro;
    }

    public void carregaLivro(EditText titulo, EditText autor, TextView genero, EditText ano, TextView status, EditText qtdPg, EditText pgAtua, TextView data1, TextView data2){

        titulo.setText(this.livro.getTitulo());
        autor.setText(this.livro.getAutor());
        genero.setText(this.livro.getGenero());
        ano.setText(this.livro.getAno());
        status.setText(this.livro.getStatus());
        qtdPg.setText(this.livro.getQtdPg());
        pgAtua.setText(this.livro.getPgAtual());
        data1.setText(this.livro.getDataInicial());
        data2.setText(this.livro.getDataFinal());
    }

    public int setLivroIcon(){
        switch (this.livro.getGenero()) {
            case "Terror":
                return R.drawable.terror_icon;
            case "Comédia":
                return R.drawable.clown_icon;

            case "Ação":
                return R.drawable.terror_icon;

            case "Ficção Científica":
                return R.drawable.fiction_icon;

            case "Fantasia":
                return R.drawable.fantasy_icon;

            case "Romance":
                return R.drawable.romance_icon;

            case "Outro":
                return R.drawable.abook;
        }
        return R.drawable.abook;
    }

}
