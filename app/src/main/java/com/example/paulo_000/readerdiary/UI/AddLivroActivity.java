package com.example.paulo_000.readerdiary.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paulo_000.readerdiary.Model.Livro;
import com.example.paulo_000.readerdiary.Model.Usuario;
import com.example.paulo_000.readerdiary.Services.Fonte;
import com.example.paulo_000.readerdiary.Services.GerenciadorLivro;
import com.example.paulo_000.readerdiary.Persistencia.App;
import com.example.paulo_000.readerdiary.R;


import java.util.Calendar;

import io.objectbox.Box;

public class AddLivroActivity extends AppCompatActivity {

    EditText editTitulo,editAutor, editAno, editQtdpg,editPaginaAtual;
    TextView editStatus, editData,editData2,editGenero,avaliar,dataButton1,dataButton2;

    private Livro livro;

    private Box<Usuario> usuarioBox;
    private Box<Livro> livrosBox;
    private Usuario usuario;

    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_livro);

        livrosBox = ((App) getApplication()).getBoxStore().boxFor(Livro.class);
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);

        Intent intent = getIntent();
        long livroId = intent.getLongExtra("livroId", -1);

        usuario = obterUsuarioLogado();
        setupViews();

        if (livroId == -1) {
            livro = new Livro();
        } else {
            livro = livrosBox.get(livroId);
            GerenciadorLivro gerenciador = new GerenciadorLivro(livro);
            gerenciador.carregaLivro(editTitulo,editAutor, editGenero,editAno,editStatus,editQtdpg,editPaginaAtual,editData,editData2);
        }
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getSharedPreferences("readerdiary", MODE_PRIVATE);
        final long id = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }


    public void AddCancelar(View view) {
        startActivity(new Intent(this, ListaLivrosActivity.class));
    }

    private void setupViews() {
        editTitulo = findViewById(R.id.add_titulo);
        editAutor = findViewById(R.id.add_autor);
        editGenero = findViewById(R.id.add_genero);
        editAno = findViewById(R.id.add_ano);
        editQtdpg = findViewById(R.id.add_pg);
        editStatus = findViewById(R.id.add_status);
        editData = findViewById(R.id.data_inicial);
        editData2 = findViewById(R.id.data_final);
        editPaginaAtual = findViewById(R.id.pagina_atual);
        avaliar = findViewById(R.id.avaliar);
        dataButton1 = findViewById(R.id.data_ini_txt);
        dataButton2 = findViewById(R.id.data_fim_txt);

        final Fonte fonte = new Fonte(this);
        fonte.setarFonteNoLivro(editTitulo,editAutor,editGenero,editAno,editStatus,editQtdpg,editPaginaAtual,editData,editData2);
        fonte.setarFonte(avaliar);
        fonte.setarFonte(dataButton1);
        fonte.setarFonte(dataButton2);
    }

    public void salvarLivro(View view) {

        String titulo = editTitulo.getText().toString();
        String autor = editAutor.getText().toString();
        String ano = editAno.getText().toString();
        String genero = editGenero.getText().toString();
        String numeroDePg = editQtdpg.getText().toString();
        String status = editStatus.getText().toString();
        String dataInicial = editData.getText().toString();
        String dataFinal = editData2.getText().toString();
        String pgAtual = editPaginaAtual.getText().toString();

        livro.getDono().setTarget(usuario);

        livro.salvaLivro(titulo,autor,genero,ano,status,numeroDePg,dataInicial,pgAtual,dataFinal);

        livrosBox.put(livro);

        Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show();
        finish();

    }


    public boolean status(View view) {

        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.status,popup.getMenu());
        popup.setOnMenuItemClickListener((menuItem -> {
            if (menuItem.getItemId() == R.id.lido) {
                editData.setVisibility(View.VISIBLE);
                editData2.setVisibility(View.VISIBLE);
                dataButton1.setVisibility(View.VISIBLE);
                dataButton2.setVisibility(View.VISIBLE);
                editPaginaAtual.setVisibility(View.INVISIBLE);
                avaliar.setVisibility(View.VISIBLE);
                editStatus.setText("Lido");
                editStatus.setTextColor(getResources().getColor(R.color.green));

            }if (menuItem.getItemId() == R.id.lendo) {
                editStatus.setText("Lendo");
                dataButton1.setVisibility(View.VISIBLE);
                dataButton2.setVisibility(View.INVISIBLE);
                editData.setVisibility(View.VISIBLE);
                editData2.setVisibility(View.INVISIBLE);
                editPaginaAtual.setVisibility(View.VISIBLE);
                editStatus.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
            if (menuItem.getItemId() == R.id.interessado) {
                editData.setVisibility(View.INVISIBLE);
                editData2.setVisibility(View.INVISIBLE);
                editPaginaAtual.setVisibility(View.INVISIBLE);
                editStatus.setText("Desejo ler");
            }
            return false;
        }));
        popup.show();
        return true;
    }

    public void calendarioDataInicial(View view) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        editData.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);


                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    public void calendarioDataFinal(View view) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        editData2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public boolean genero(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.getMenuInflater().inflate(R.menu.generos,popup.getMenu());
        popup.setOnMenuItemClickListener(((MenuItem menuItem) -> {
            if (menuItem.getItemId() == R.id.terror) {
                editGenero.setText("Terror");
            }

            if (menuItem.getItemId() == R.id.romance) {
                editGenero.setText("Romance");
            }

            if (menuItem.getItemId() == R.id.outro) {
                editGenero.setText("Outro");
            }

            if (menuItem.getItemId() == R.id.acao) {
                editGenero.setText("Ação");
            }

            if (menuItem.getItemId() == R.id.fantasia) {
                editGenero.setText("Fantasia");
            }

            if (menuItem.getItemId() == R.id.comedia) {
                editGenero.setText("Comédia");
            }

            if (menuItem.getItemId() == R.id.ficcao) {
                editGenero.setText("Ficção Científica");
            }

            return false;
        }));
        popup.show();
        return true;
    }

    public boolean nota(View view) {
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.getMenuInflater().inflate(R.menu.notas, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(((MenuItem menuItem)-> {

            if (menuItem.getItemId() == R.id.nota1) {
                livro.setNotaDeAvaliação(1.0f);
            }

            if (menuItem.getItemId() == R.id.nota2) {
                livro.setNotaDeAvaliação(2.0f);
            }

            if (menuItem.getItemId() == R.id.nota3) {
                livro.setNotaDeAvaliação(3.0f);
            }

            if (menuItem.getItemId() == R.id.nota4) {
                livro.setNotaDeAvaliação(4.0f);
            }

            if (menuItem.getItemId() == R.id.nota5) {
                livro.setNotaDeAvaliação(5.0f);
            }


            return false;
        }));
        popupMenu.show();
        return true;
    }
}