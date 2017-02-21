package com.developers.carlos.uppy.mascota_favoritos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.developers.carlos.uppy.OnItemClickListener;
import com.developers.carlos.uppy.R;
import com.developers.carlos.uppy.adaptadores.MascotaAdaptador;
import com.developers.carlos.uppy.adaptadores.MascotaFavoritoAdaptador;
import com.developers.carlos.uppy.mascotas.IMascotaPresenter;
import com.developers.carlos.uppy.mascotas.MascotaIteractorImp;
import com.developers.carlos.uppy.mascotas.MascotaPresenterImp;
import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

public class FavoritosActivity extends AppCompatActivity implements IFavoritosView{

    private IFavoritosPresenter favoritosPresenter;
    private MascotaFavoritoAdaptador mascotaAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        setToolbar();

        RecyclerView miRecycler = (RecyclerView) findViewById(R.id.mi_recycler);
        mascotaAdaptador = crearAdaptador();
        setupRecycler(miRecycler,mascotaAdaptador);

        favoritosPresenter = new FavoritosPresenterImp(this,new FavoritosIteractorImp(),this.getBaseContext());
    }

    @Override
    protected void onResume() {
        super.onPostResume();
        favoritosPresenter.onResume();
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setData(List<Mascota> mascotas) {
        mascotaAdaptador.setItems(mascotas);
    }

    @Override
    public void mostrarToast(String msj) {
        Toast.makeText(this,msj,Toast.LENGTH_SHORT).show();
    }

    private void setupRecycler(RecyclerView miRecycler, RecyclerView.Adapter adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        miRecycler.setLayoutManager(linearLayoutManager);
        miRecycler.setAdapter(adapter);
    }

    private MascotaFavoritoAdaptador crearAdaptador(){
        MascotaFavoritoAdaptador mascotaAdaptador = new MascotaFavoritoAdaptador();
        mascotaAdaptador.setItemClickListener(new OnItemClickListener<Mascota>() {
            @Override
            public void onItemClicked(int position, Mascota item) {
                favoritosPresenter.onClickItem(position, item);
            }
        });
        return mascotaAdaptador;

    }
}
