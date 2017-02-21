package com.developers.carlos.uppy.mascota_favoritos;

import android.content.Context;

import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 20/02/17.
 */

public class FavoritosPresenterImp implements IFavoritosPresenter, IFavoritosIteractor.OnFinishedListener {

    private IFavoritosView favoritosView;
    private IFavoritosIteractor favoritosIteractor;
    private Context context;

    public FavoritosPresenterImp(IFavoritosView favoritosView, IFavoritosIteractor favoritosIteractor, Context context) {
        this.favoritosView = favoritosView;
        this.favoritosIteractor = favoritosIteractor;
        this.context = context;
    }

    @Override
    public void onResume() {
        favoritosIteractor.obtenerTop5(this,context);
    }

    @Override
    public void onClickItem(int position, Mascota mascota) {

        position = position+1;
        favoritosView.mostrarToast(mascota.getNombre()+" es la Nro. "+position);

    }

    @Override
    public void onSuccess(List<Mascota> items) {
        favoritosView.setData(items);
    }

    @Override
    public void onError(Throwable t) {
        favoritosView.mostrarToast("Ha ocurrido un error inesperado");
    }
}
