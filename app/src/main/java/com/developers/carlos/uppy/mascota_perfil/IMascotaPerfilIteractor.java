package com.developers.carlos.uppy.mascota_perfil;

import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 17/02/17.
 */

public interface IMascotaPerfilIteractor {

    interface OnFinishedListener {
        void onSuccess(List<Mascota> items);
        void onError(Throwable t);
    }

    void obtenerPerfil(IMascotaPerfilIteractor.OnFinishedListener listener);
}
