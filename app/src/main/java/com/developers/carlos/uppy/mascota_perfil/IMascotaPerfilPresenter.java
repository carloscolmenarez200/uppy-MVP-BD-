package com.developers.carlos.uppy.mascota_perfil;

import com.developers.carlos.uppy.modelos.Mascota;

/**
 * Created by carlos on 17/02/17.
 */

public interface IMascotaPerfilPresenter {

    void onClickItem(int position, Mascota mascota);

    void onResume();
}
