package com.example.digitalhousefoods.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digitalhousefoods.R;
import com.example.digitalhousefoods.adapters.PratoAdapter;
import com.example.digitalhousefoods.interfaces.RecyclerViewOnClickPratos;
import com.example.digitalhousefoods.models.Prato;
import com.example.digitalhousefoods.models.Restaurante;

import java.util.ArrayList;
import java.util.List;

import static com.example.digitalhousefoods.views.HomeActivity.RESTAURANTE_KEY;

public class DetalheRestauranteActivity extends AppCompatActivity implements RecyclerViewOnClickPratos {

    private ImageView imagemRestaurante;
    private TextView nomeRestaurante;
    private RecyclerView recyclerView;
    private PratoAdapter adapter;
    private List<Prato> listaPratos = new ArrayList<>();
    public static final String PRATO_KEY = "prato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante);

        recyclerView = findViewById(R.id.recyclerViewPratos);
        adapter = new PratoAdapter(retornaListaPratos(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Restaurante restaurante = getIntent().getExtras().getParcelable(RESTAURANTE_KEY);

            Drawable drawable = getResources().getDrawable(restaurante.getImagem());
            imagemRestaurante.setImageDrawable(drawable);
            nomeRestaurante.setText(restaurante.getNomeRestaurante());
        }
    }

    public List<Prato> retornaListaPratos() {

        listaPratos.add(new Prato(R.drawable.aoyama, "Carne suculenta",
                "A alcatra é um tipo de corte da carne bovina localizada na parte traseira do animal. Considerada uma carne de primeira, é macia, tem tom vermelho forte e não tem rebarbas de gordura ou nervos. Imperdível!"));
        listaPratos.add(new Prato(R.drawable.outback, "Saladinha leve",
                "Quer uma alimentação mais balanceada? A salada caprese é uma excelente opção. O prato é uma combinação de apenas cinco ingredientes: tomate, muçarela de búfala, manjericão, sal e azeite de oliva.\n"));
        listaPratos.add(new Prato(R.drawable.sisenor, "Massa saborosa",
                "Você sabia? Estudos mostram que as massas não são o grande vilão na luta pelo emagrecimento! Pelo contrário: se incluída dentro das necessidades calóricas de cada indivíduo, a receita favorece uma composição corporal saudável."));
        listaPratos.add(new Prato(R.drawable.tony, "Sugestão do chef",
                "Venha conhecer os pratos incríveis que o nosso chefe separou especialmente para você. Sempre uma novidade a cada semana!"));
        listaPratos.add(new Prato(R.drawable.splash, "Opção veggie",
                "Você já experimentou tirar a carne do prato e optar por outro alimento? O hábito tem sido incentivado por campanhas como a Segunda Sem Carne, que mostra que é possível ter refeições nutritivas e gostosas sem carne vermelha, frango ou peixe."));
        listaPratos.add(new Prato(R.drawable.aoyama, "Menu kids",
                "Quanto mais colorido for o prato do seu filho, mais saudável e rico em nutrientes ele será. Saber a quantidade diária de calorias ideal para o pequeno é essencial e esse prato te ajuda nessa missão!"));

        return listaPratos;

    }

    public void initViews () {
        imagemRestaurante = findViewById(R.id.imagemRestaurante);
        nomeRestaurante = findViewById(R.id.nomeRestaurante);
    }

    @Override
    public void onClick(Prato prato) {
        Intent intent = new Intent(DetalheRestauranteActivity.this, DetalhePratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRATO_KEY, prato);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
