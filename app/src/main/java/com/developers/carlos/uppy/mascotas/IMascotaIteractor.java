package com.developers.carlos.uppy.mascotas;

import android.content.Context;

import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 16/02/17.
 */

public interface IMascotaIteractor {

    interface OnFinishedListener {
        void onSuccess(List<Mascota> items);
        void onError(Throwable t);
    }

    void obtenerMascotas(OnFinishedListener listener, Context context);

    void insertarData(List<Mascota> mascotas,Context context);

    void onClickMeGusta(Mascota mascota, Context context);
}
