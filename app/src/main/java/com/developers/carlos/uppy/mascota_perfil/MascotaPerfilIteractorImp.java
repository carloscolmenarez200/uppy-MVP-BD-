package com.developers.carlos.uppy.mascota_perfil;

import android.os.Handler;

import com.developers.carlos.uppy.mascotas.IMascotaIteractor;
import com.developers.carlos.uppy.modelos.MascotaData;

/**
 * Created by carlos on 17/02/17.
 */

public class MascotaPerfilIteractorImp implements IMascotaPerfilIteractor{


    @Override
    public void obtenerPerfil(final IMascotaPerfilIteractor.OnFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                if(MascotaData.MASCOTAS_DATA_PERFIL.isEmpty()){
                    listener.onError(new Throwable(new Exception()));
                }
                listener.onSuccess(MascotaData.MASCOTAS_DATA_PERFIL);
            }
        }, 2000);
    }
}
