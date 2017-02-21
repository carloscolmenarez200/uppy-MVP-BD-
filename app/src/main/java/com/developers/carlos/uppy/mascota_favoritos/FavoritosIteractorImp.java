package com.developers.carlos.uppy.mascota_favoritos;

import android.content.Context;
import android.os.Handler;

import com.developers.carlos.uppy.BD.MascotaDB;
import com.developers.carlos.uppy.modelos.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlos on 20/02/17.
 */

public class FavoritosIteractorImp implements IFavoritosIteractor{

    @Override
    public void obtenerTop5(final OnFinishedListener listener, Context context) {
        final MascotaDB mascotaDB = new MascotaDB(context);

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                List<Mascota> mascotas = (mascotaDB.getMascotas());
                List<Mascota> top5 = new ArrayList<>();

                for (int i=0; i<mascotas.size(); i++){
                    if(i==5) break;
                    top5.add(mascotas.get(i));
                }

                if(top5.isEmpty()){
                    listener.onError(new Throwable(new Exception()));
                }
                listener.onSuccess(top5);
            }
        }, 2000);
    }
}
