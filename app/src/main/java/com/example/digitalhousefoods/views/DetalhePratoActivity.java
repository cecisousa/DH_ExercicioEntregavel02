package com.example.digitalhousefoods.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalhousefoods.R;
import com.example.digitalhousefoods.models.Prato;

import static com.example.digitalhousefoods.views.DetalheRestauranteActivity.PRATO_KEY;

public class DetalhePratoActivity extends AppCompatActivity {

    private ImageView imagemPrato;
    private TextView nomePrato;
    private TextView descricaoPrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_prato);

        initViews ();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Prato prato = getIntent().getExtras().getParcelable(PRATO_KEY);

            Drawable drawable = getResources().getDrawable(prato.getImagem());
            imagemPrato.setImageDrawable(drawable);
            nomePrato.setText(prato.getNomePrato());
            descricaoPrato.setText(prato.getDescricaoPrato());
        }

    }

    public void initViews() {
        imagemPrato = findViewById(R.id.imagemPrato);
        nomePrato = findViewById(R.id.nomePrato);
        descricaoPrato = findViewById(R.id.descricaoPrato);
    }

}
