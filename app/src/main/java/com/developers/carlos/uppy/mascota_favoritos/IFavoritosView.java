package com.developers.carlos.uppy.mascota_favoritos;

import com.developers.carlos.uppy.modelos.Mascota;

import java.util.List;

/**
 * Created by carlos on 20/02/17.
 */

public interface IFavoritosView {

    void setData(List<Mascota> mascotas);

    void mostrarToast(String msj);
}
