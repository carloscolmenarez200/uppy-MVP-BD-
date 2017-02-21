package com.developers.carlos.uppy.mascota_favoritos;

import com.developers.carlos.uppy.modelos.Mascota;

/**
 * Created by carlos on 20/02/17.
 */

public interface IFavoritosPresenter {

    void onClickItem(int position, Mascota mascota);

    void onResume();
}
