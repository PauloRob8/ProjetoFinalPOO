package com.example.paulo_000.readerdiary.UI;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.paulo_000.readerdiary.Model.Capitulo;
import com.example.paulo_000.readerdiary.Model.Capitulo_;
import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Persistencia.App;
import com.example.paulo_000.readerdiary.R;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;

import static com.example.paulo_000.readerdiary.R.*;

public class CapitulosActivity extends AppCompatActivity {

    TextView capitulo,vTitulo,vGenero,vAno,vAutor,vPaginas,vData1,vData2,vStatus,info,opniao;
    RatingBar ratingBar;

    private Box<Livro> livroBox;
    private Box<Capitulo> capitulosBox;
    private Livro livro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_capitulos);

        setupViews();

        BoxStore store = ((App)getApplication()).getBoxStore();
        capitulosBox = store.boxFor(Capitulo.class);

        livroBox = ((App) getApplication()).getBoxStore().boxFor(Livro.class);

        Intent intent = getIntent();
        long livroId = intent.getLongExtra("livroId", -1);

        livro = livroBox.get(livroId);

        carregaLivro(livro);

        ratingBar.setRating(livro.getNotaDeAvaliação());

    }


    protected void onResume() {
        super.onResume();
        QueryBuilder<Capitulo> builder = capitulosBox.query();
        builder.equal(Capitulo_.livroId,livro.getId());


        List<Capitulo> capituloDoLivro = builder.build().find();

        loadData(capituloDoLivro);

    }

    private void loadData(List<Capitulo> data){
        List<Capitulo> capitulos = data;

        CapitulosAdapter adapter = new CapitulosAdapter(this, capitulos,capitulosBox);

        RecyclerView rvCapitulos = findViewById(id.rv_capitulos);

        rvCapitulos.setAdapter(adapter);
        rvCapitulos.setLayoutManager(new LinearLayoutManager(this));
        rvCapitulos.setHasFixedSize(true);
    }


    public void setupViews(){

        Typeface font = Typeface.createFromAsset(getAssets(),"font2.TTF");

        capitulo = findViewById(id.capitulos);
        vTitulo = findViewById(R.id.v_titulo);
        vAno = findViewById(R.id.v_ano);
        vGenero = findViewById(id.v_genero);
        vAutor = findViewById(id.v_autor);
        vData1 = findViewById(id.v_data1);
        vData2 = findViewById(id.v_data2);
        vPaginas = findViewById(id.v_qtdPg);
        vStatus = findViewById(id.v_status);
        info = findViewById(R.id.info);
        opniao = findViewById(id.opniao);
        ratingBar = findViewById(id.avaliacao);

        vTitulo.setTypeface(font);
        info.setTypeface(font);
        vAno.setTypeface(font);
        vAutor.setTypeface(font);
        vGenero.setTypeface(font);
        vPaginas.setTypeface(font);
        capitulo.setTypeface(font);
        vData1.setTypeface(font);
        vStatus.setTypeface(font);
        vData2.setTypeface(font);
        vStatus.setTypeface(font);
        opniao.setTypeface(font);

    }

    public void carregaLivro(Livro livro) {
        vTitulo.setText(livro.getTitulo());
        vAutor.setText(livro.getAutor());
        vGenero.setText(livro.getGenero());
        vAno.setText(livro.getAno());
        vStatus.setText(livro.getStatus());
        vPaginas.setText(livro.getQtdPg());
        vData1.setText(livro.getDataInicial());
        vData2.setText(livro.getDataFinal());

        if(livro.getStatus().equals("Lido")){
            opniao.setVisibility(View.VISIBLE);
            ratingBar.setVisibility(View.VISIBLE);
        }
    }



    public void addCapitulo(View view) {
        Intent intent = getIntent();
        final long id = intent.getLongExtra("livroId", -1);
        Intent intent1 = new Intent(this, AddCapituloActivity.class);
        intent1.putExtra("livroId",id);
        startActivity(intent1);
    }

}
