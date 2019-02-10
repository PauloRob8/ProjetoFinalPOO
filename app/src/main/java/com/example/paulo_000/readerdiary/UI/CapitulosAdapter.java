package com.example.paulo_000.readerdiary.UI;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.paulo_000.readerdiary.Model.Capitulo;
import com.example.paulo_000.readerdiary.R;

import java.util.List;

import io.objectbox.Box;


public class CapitulosAdapter extends RecyclerView.Adapter<CapitulosAdapter.CapitulosViewHolder>{

    private Context context;
    private List<Capitulo> capitulos;
    private Box<Capitulo> box;

    public CapitulosAdapter(Context context, List<Capitulo> capitulos, Box<Capitulo> box) {
        this.box = box;
        this.context = context;
        this.capitulos = capitulos;
    }

    @Override
    public CapitulosAdapter.CapitulosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_item_capitulos,parent,false);
        CapitulosAdapter.CapitulosViewHolder holder = new CapitulosAdapter.CapitulosViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(CapitulosAdapter.CapitulosViewHolder holder, int position) {
        final Capitulo capitulo = this.capitulos.get(position);
        holder.capTitulo.setText(capitulo.getTitulo());
        holder.capComentario.setText(capitulo.getDescricao());
        holder.capNum.setText(""+capitulo.getCapNum());

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popup = new PopupMenu(context, view);
                popup.getMenuInflater().inflate(R.menu.capitulos_options, popup.getMenu());
                popup.setOnMenuItemClickListener((menuItem -> {
                    if(menuItem.getItemId() == R.id.remover_cap){
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Confirmação");
                        builder.setIcon(R.mipmap.ic_alert);
                        builder.setMessage("Deseja mesmo remover o capítulo?" + " " + capitulo.getTitulo());
                        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                capitulos.remove(capitulo);
                                box.remove(capitulo);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,getItemCount());
                            }
                        });
                        builder.setNegativeButton("NÃO",null);
                        builder.show();
                    }

                    return false;
                }));
                popup.show();
                return true;
            }

            });
    }

    @Override
    public int getItemCount() {
        return capitulos.size();
    }


    public static class CapitulosViewHolder extends RecyclerView.ViewHolder {

       private TextView capTitulo,capComentario,capNum;
       private CardView cardView;


        public CapitulosViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cap_card);
            capNum = itemView.findViewById(R.id.cap_numero);
            capTitulo = itemView.findViewById(R.id.cap_titulo);
            capComentario = itemView.findViewById(R.id.cap_coment);

        }

    }

}

