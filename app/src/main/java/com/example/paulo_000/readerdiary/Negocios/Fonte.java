package com.example.paulo_000.readerdiary.Negocios;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;


public class Fonte {

    Context context;
    Typeface font;

    public Fonte(Context context){
        this.context = context;
        AssetManager mngr = context.getAssets();
        this.font = Typeface.createFromAsset(mngr,"font2.TTF");
    }



    public void setarFonteNoLivro(EditText titulo, EditText autor, TextView genero, EditText ano, TextView status, EditText qtdPg, EditText pgAtual, TextView data1, TextView data2) {

        titulo.setTypeface(font);
        autor.setTypeface(font);
        genero.setTypeface(font);
        ano.setTypeface(font);
        status.setTypeface(font);
        qtdPg.setTypeface(font);
        pgAtual.setTypeface(font);
        data1.setTypeface(font);
        data2.setTypeface(font);
    }

    public void setarFonte(TextView text1, TextView text2, TextView text3, TextView text4){
        text1.setTypeface(font);
        text2.setTypeface(font);
        text3.setTypeface(font);
        text4.setTypeface(font);
    }

    public void setarFonte(TextView text){
        text.setTypeface(font);
    }

    public void setarFonte(EditText text){
        text.setTypeface(font);
    }

}
