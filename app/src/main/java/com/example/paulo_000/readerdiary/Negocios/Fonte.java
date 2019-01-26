package com.example.paulo_000.readerdiary.Negocios;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;


public class Fonte {

    Context context;
    Typeface font,font1;

    public Fonte(Context context){
        this.context = context;
        AssetManager mngr = context.getAssets();
        this.font = Typeface.createFromAsset(mngr,"DancingScript.ttf");
        this.font1 = Typeface.createFromAsset(mngr,"font2.TTF");
    }


    public void setarFonte1(EditText texto){
        texto.setTypeface(font);
    }

    public void setarFonte1(TextView text){
        text.setTypeface(font);
    }

    public void setartFonte1(TextView text1,TextView text2,TextView text3,TextView text4){
        text1.setTypeface(font1);
        text2.setTypeface(font1);
        text3.setTypeface(font1);
        text4.setTypeface(font1);
    }

    public void setarFonte2(EditText texto){
        texto.setTypeface(font1);
    }

    public void setarFonte2(TextView text){
        text.setTypeface(font1);
    }
}
