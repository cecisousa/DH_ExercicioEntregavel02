package com.example.digitalhousefoods.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalhousefoods.R;
import com.example.digitalhousefoods.interfaces.RecyclerViewOnClickPratos;
import com.example.digitalhousefoods.models.Prato;

import java.util.List;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolder> {

    private List<Prato> listaPratos;
    private RecyclerViewOnClickPratos listener;

    public PratoAdapter (List<Prato> listaPratos, RecyclerViewOnClickPratos listener) {
        this.listaPratos = listaPratos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_prato,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Prato prato = listaPratos.get(position);
        holder.onBind(prato);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(prato);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagemPrato;
        private TextView nomePrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagemPrato = itemView.findViewById(R.id.imgPequenaPrato);
            nomePrato = itemView.findViewById(R.id.txtPrato);
        }

        public void onBind (Prato prato){
            Drawable drawable = itemView.getResources().getDrawable(prato.getImagem());
            imagemPrato.setImageDrawable(drawable);
            nomePrato.setText(prato.getNomePrato());
        }
    }
}
