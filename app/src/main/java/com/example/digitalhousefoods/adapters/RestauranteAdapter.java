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
import com.example.digitalhousefoods.interfaces.RecyclerViewOnClickRestaurantes;
import com.example.digitalhousefoods.models.Restaurante;

import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private List<Restaurante> listaRestaurantes;
    private RecyclerViewOnClickRestaurantes listener;

    public RestauranteAdapter (List<Restaurante> listaRestaurantes, RecyclerViewOnClickRestaurantes listener){
        this.listaRestaurantes = listaRestaurantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_restaurante,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Restaurante restaurante = listaRestaurantes.get(position);
        holder.onBind(restaurante);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restaurante);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagemRestaurante;
        private TextView nomeRestaurante;
        private TextView endereco;
        private TextView fechamento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagemRestaurante = itemView.findViewById(R.id.imageView);
            nomeRestaurante = itemView.findViewById(R.id.txtNome);
            endereco = itemView.findViewById(R.id.txtEndereco);
            fechamento = itemView.findViewById(R.id.txtFechamento);

        }

        public void onBind (Restaurante restaurante) {
            Drawable drawable = itemView.getResources().getDrawable(restaurante.getImagem());
            imagemRestaurante.setImageDrawable(drawable);
            nomeRestaurante.setText(restaurante.getNomeRestaurante());
            endereco.setText(restaurante.getEndereço());
            fechamento.setText(restaurante.getFechamento());
        }
    }
}
