package com.example.paulo_000.readerdiary.UI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Model.Livro_;
import com.example.paulo_000.readerdiary.Model.Usuario;
import com.example.paulo_000.readerdiary.Persistencia.App;
import com.example.paulo_000.readerdiary.R;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;

public class ListaLivrosActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Box<Livro> livroBox;
    private Box<Usuario> usuarioBox;
    SharedPreferences preferences;
    private Usuario usuarioLogado;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_livros);

        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.abrir,R.string.fechar);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setNavigationViewListner();

        BoxStore store = ((App)getApplication()).getBoxStore();
        livroBox = store.boxFor(Livro.class);
        usuarioBox = store.boxFor(Usuario.class);

        usuarioLogado = obterUsuarioLogado();

        if(!logado()){
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }

    protected void onResume() {
        super.onResume();
        QueryBuilder<Livro> builder = livroBox.query();
        builder.equal(Livro_.donoId, usuarioLogado.getId());

        List<Livro> livrosDoUsuario = builder.build().find();

        loadData(livrosDoUsuario);
    }

    private void loadData(List<Livro> data){
        List<Livro> livros = data;

        LivrosAdapter adapter = new LivrosAdapter(this, livros, livroBox);

        RecyclerView rvLivros = findViewById(R.id.rv_livros);

        rvLivros.setAdapter(adapter);
        rvLivros.setLayoutManager(new LinearLayoutManager(this));
        rvLivros.setHasFixedSize(true);
    }

    public void AdicionarLivro(View view) {
        startActivity(new Intent(this,AddLivroActivity.class));
    }

    private boolean logado() {
        preferences = getSharedPreferences("readerdiary", MODE_PRIVATE);
        long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioId != -1;
    }

    private void setNavigationViewListner() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int  id = item.getItemId();
        if(id == R.id.lidos){
            RecyclerView rvLivros = findViewById(R.id.rv_livros);
            List<Livro> livroList = livroBox.query().equal(Livro_.status,"Lido").equal(Livro_.donoId,usuarioLogado.getId()).build().find();
            LivrosAdapter adapter = new LivrosAdapter(this, livroList,livroBox);
            rvLivros.setAdapter(adapter);
            rvLivros.setLayoutManager(new LinearLayoutManager(this));
            rvLivros.setHasFixedSize(true);
        }
        if(id == R.id.interrese){
            RecyclerView rvLivros = findViewById(R.id.rv_livros);
            List<Livro> livroList = livroBox.query().equal(Livro_.status,"Desejo ler").equal(Livro_.donoId,usuarioLogado.getId()).build().find();
            LivrosAdapter adapter = new LivrosAdapter(this, livroList,livroBox);
            rvLivros.setAdapter(adapter);
            rvLivros.setLayoutManager(new LinearLayoutManager(this));
            rvLivros.setHasFixedSize(true);
        }

        if(id == R.id.Lendo){
            RecyclerView rvLivros = findViewById(R.id.rv_livros);
            List<Livro> livroList = livroBox.query().equal(Livro_.status,"Lendo").equal(Livro_.donoId,usuarioLogado.getId()).build().find();
            LivrosAdapter adapter = new LivrosAdapter(this, livroList,livroBox);
            rvLivros.setAdapter(adapter);
            rvLivros.setLayoutManager(new LinearLayoutManager(this));
            rvLivros.setHasFixedSize(true);
        }


        if(id == R.id.logout){
            logout();
        }

        return false;
    }



    public void play(MenuItem item){
        if(player == null){
            player = MediaPlayer.create(this,R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }
        player.start();
    }

    public void pausar(MenuItem item){
        if(player != null ){
            player.pause();
        }
    }

    public void parar(MenuItem item){
        stopPlayer();
    }

    public void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        preferences.edit().clear();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getSharedPreferences("readerdiary", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }

}
