package com.example.digitalhousefoods.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.digitalhousefoods.R;
import com.example.digitalhousefoods.adapters.RestauranteAdapter;
import com.example.digitalhousefoods.interfaces.RecyclerViewOnClickRestaurantes;
import com.example.digitalhousefoods.models.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements RecyclerViewOnClickRestaurantes {

    private RecyclerView recyclerView;
    private RestauranteAdapter adapter;
    private List<Restaurante> listaRestaurantes = new ArrayList<>();
    public static final String RESTAURANTE_KEY = "restaurante";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerViewRestaurantes);
        adapter = new RestauranteAdapter(retornaListaRestaurantes(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<Restaurante> retornaListaRestaurantes () {
        listaRestaurantes.add(new Restaurante(R.drawable.tony, "Tony Roma's",
                "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00"));
        listaRestaurantes.add(new Restaurante(R.drawable.aoyama, "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema, São Paulo", "Fecha à 00:00"));
        listaRestaurantes.add(new Restaurante(R.drawable.outback, "Outback - Moema",
                "Av. Moaci, 187 - Moema, São Paulo", "Fecha à 00:00"));
        listaRestaurantes.add(new Restaurante(R.drawable.sisenor, "Sí Señor!",
                "Alameda Jauaperi, 626 - Moema, São Paulo", "Fecha à 01:00"));

        return listaRestaurantes;

    }

    @Override
    public void onClick(Restaurante restaurante) {
        Intent intent = new Intent(HomeActivity.this, DetalheRestauranteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANTE_KEY, restaurante);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_perfil) {
            startActivity(new Intent(HomeActivity.this, PerfilActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
