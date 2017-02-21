package com.developers.carlos.uppy.mascota_favoritos;

import android.content.Context;

import com.developers.carlos.uppy.mascota_perfil.IMascotaPerfilIteractor;
import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 20/02/17.
 */

public interface IFavoritosIteractor {

    interface OnFinishedListener {
        void onSuccess(List<Mascota> items);
        void onError(Throwable t);
    }

    void obtenerTop5(IFavoritosIteractor.OnFinishedListener listener, Context context);
}
