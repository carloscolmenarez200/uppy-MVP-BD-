package com.developers.carlos.uppy.mascotas;

import android.content.Context;
import android.os.Handler;
import com.developers.carlos.uppy.BD.MascotaDB;
import com.developers.carlos.uppy.modelos.Mascota;
import com.developers.carlos.uppy.utils.Prefs;

import java.util.List;

/**
 * Created by carlos on 16/02/17.
 */

public class MascotaIteractorImp implements IMascotaIteractor{


    @Override
    public void obtenerMascotas(final OnFinishedListener listener, Context context) {

        final MascotaDB mascotaDB = new MascotaDB(context);

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                List<Mascota> mascotas = (mascotaDB.getMascotas());
                if(mascotas.isEmpty()){
                    listener.onError(new Throwable(new Exception()));
                }
                listener.onSuccess(mascotas);
            }
        }, 2000);

    }

    @Override
    public void insertarData(List<Mascota> mascotas, Context context) {

        if(Prefs.with(context).isBdBandera()){
            return;
        }

        final MascotaDB mascotaDB = new MascotaDB(context);

        for (Mascota m: mascotas){
            mascotaDB.guardarMascota(m);
        }
        Prefs.with(context).setBdBandera(true);
    }

    @Override
    public void onClickMeGusta(Mascota mascota, Context context) {

        final MascotaDB mascotaDB = new MascotaDB(context);
        mascotaDB.updateMascota(mascota);

    }
}
