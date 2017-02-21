package com.developers.carlos.uppy.mascota_perfil;

import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 17/02/17.
 */

public class MascotaPerfilPresenterImp implements IMascotaPerfilPresenter, IMascotaPerfilIteractor.OnFinishedListener {

    private IMascotaPerfilView mascotaPerfilView;
    private IMascotaPerfilIteractor mascotaPerfilIteractor;


    public MascotaPerfilPresenterImp(IMascotaPerfilView mascotaPerfilView, IMascotaPerfilIteractor mascotaPerfilIteractor) {

        this.mascotaPerfilView = mascotaPerfilView;
        this.mascotaPerfilIteractor = mascotaPerfilIteractor;
    }

    @Override
    public void onClickItem(int position, Mascota mascota) {
        mascotaPerfilView.mostrarToast("has clickeado la foto de "+mascota.getNombre()+" nro: "+(position+1));
    }

    @Override
    public void onResume() {
        mascotaPerfilIteractor.obtenerPerfil(this);
    }

    @Override
    public void onSuccess(List<Mascota> items) {
        mascotaPerfilView.setData(items);
    }

    @Override
    public void onError(Throwable t) {
        mascotaPerfilView.mostrarToast("Ha ocurrido un error inesperado");
    }
}
