package com.example.paulo_000.readerdiary.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.paulo_000.readerdiary.Model.Capitulo;
import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Persistencia.App;
import com.example.paulo_000.readerdiary.R;
import com.example.paulo_000.readerdiary.Services.Fonte;

import io.objectbox.Box;

public class AddCapituloActivity extends AppCompatActivity {

    EditText editTitulo, editComentario,editNum;


    private Livro livro;
    private Capitulo capitulo;


    private Box<Livro> livroBox;
    private Box<Capitulo> capitulosBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_capitulo);

        setupViews();
        livroBox = ((App) getApplication()).getBoxStore().boxFor(Livro.class);
        capitulosBox = ((App) getApplication()).getBoxStore().boxFor(Capitulo.class);

        Intent intent = getIntent();
        long capituloId = intent.getLongExtra("capituloId", -1);

        livro = obtemLivro();

        if (capituloId == -1) {
            capitulo = new Capitulo();
        } else {
            capitulo = capitulosBox.get(capituloId);
            carregaCapitulo(capitulo);
        }

    }

    public void setupViews(){
        Typeface font = Typeface.createFromAsset(getAssets(),"font2.TTF");
        editNum = findViewById(R.id.add_cap_number);
        editTitulo = findViewById(R.id.add_cap_titulo);
        editComentario = findViewById(R.id.add_comentario_titulo);
        editNum.setTypeface(font);
        editTitulo.setTypeface(font);
        editComentario.setTypeface(font);


    }

    @Override
    public void onBackPressed() {
        
       finish();
    }

    public Livro obtemLivro() {
        final SharedPreferences preferences = getSharedPreferences("readerdiary", MODE_PRIVATE);
        Intent intent = getIntent();
        final long id = intent.getLongExtra("livroId", -1);
        return livroBox.get(id);

    }


    public void carregaCapitulo(Capitulo capitulos){

        Fonte fonte = new Fonte(this);

        editNum.setText(capitulos.getTitulo());
        editTitulo.setText(capitulos.getTitulo());
        editComentario.setText(capitulos.getDescricao());

        fonte.setarFonte(editNum);
        fonte.setarFonte(editTitulo);
        fonte.setarFonte(editComentario);

    }

    public void salvarCapitulo(View view) {

       String titulo = editTitulo.getText().toString();
       String comentario = editComentario.getText().toString();
       int numero = Integer.parseInt(editNum.getText().toString());

       capitulo.getLivro().setTarget(livro);

       livro.editarCapitulo(capitulo,numero,titulo,comentario);

       capitulosBox.put(capitulo);

       Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
       finish();

    }

    public void marcarCapitulo(View view) {
        capitulo.marcarCapitulo();
        if(capitulo.isMarcado())
            Toast.makeText(this,"Capitulo marcado",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Capitulo desmarcado",Toast.LENGTH_LONG).show();


    }

    public void favoritarCapitulo(View view) {
        capitulo.favoritarCap();
        if(capitulo.isFavorito())
            Toast.makeText(this,"Capitulo favoritado",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Capitulo desfavoritado",Toast.LENGTH_LONG).show();
    }

    public void cancelar(View view) {
        this.finish();
    }
}
