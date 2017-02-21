package com.developers.carlos.uppy.mascotas;

import com.developers.carlos.uppy.modelos.Mascota;

/**
 * Created by carlos on 16/02/17.
 */

public interface IMascotaPresenter {

    void onClickMeGusta(Mascota mascota);

    void onResume();

    void insertarDB();

}
