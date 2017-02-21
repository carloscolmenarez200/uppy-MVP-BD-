package com.developers.carlos.uppy.mascotas;

import android.content.Context;

import com.developers.carlos.uppy.modelos.Mascota;
import com.developers.carlos.uppy.modelos.MascotaData;

import java.util.List;

/**
 * Created by carlos on 16/02/17.
 */

public class MascotaPresenterImp implements IMascotaPresenter, IMascotaIteractor.OnFinishedListener {


    private IMascotaView mascotaView;
    private IMascotaIteractor mascotaIteractor;
    private Context context;

    public MascotaPresenterImp(IMascotaView mascotaView, IMascotaIteractor mascotaIteractor, Context context) {
        this.mascotaView = mascotaView;
        this.mascotaIteractor = mascotaIteractor;
        this.context = context;
    }

    @Override
    public void onResume() {
        mascotaIteractor.obtenerMascotas(this,context);
    }

    @Override
    public void insertarDB() {
        mascotaIteractor.insertarData(MascotaData.MASCOTAS_DATA,context);
    }

    @Override
    public void onClickMeGusta(Mascota mascota) {
        mascotaView.mostrarToast("Ha indicado me gusta a "+mascota.getNombre());
        mascotaIteractor.onClickMeGusta(mascota,context);
    }

    @Override
    public void onSuccess(List<Mascota> items) {
        mascotaView.setData(items);
    }

    @Override
    public void onError(Throwable t) {
        mascotaView.mostrarToast("Ha ocurriodo un error inesperado");
    }
}
